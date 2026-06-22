package com.ke.gradlemusicapi.controller

import com.ke.gradlemusicapi.api.HttpService
import com.ke.gradlemusicapi.cookie
import com.ke.gradlemusicapi.entity.response.Song
import com.ke.gradlemusicapi.entity.vo.BaseVO
import com.ke.gradlemusicapi.entity.vo.SongDetailVO
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@Tag(name = "歌曲")
@RestController
class SongController(private val httpService: HttpService) {


    @Operation(summary = "获取歌曲详情")
    @SecurityRequirement(name = "Bearer Authentication")
    @GetMapping("/song/{id}")
    suspend fun songDetail(
        @Parameter(description = "歌曲id", required = true, example = "25920721")
        @PathVariable id: Long,
        authentication: Authentication
    ): BaseVO<SongDetailVO> {

        val cookie = authentication.cookie

//        val lrc = httpService.getSongLrc(id, authentication.cookie).lrc.lyric

        val url = httpService.getSongUrl(id, cookie = cookie).data.first().url
        val song = httpService.getSongDetail(id, cookie).songs.first()
//        val liked = httpService.isSongLiked("[$id]", cookie).ids.contains(id)
        return BaseVO.success(SongDetailVO(song, url))

    }

    @Operation(summary = "获取歌曲歌词")
    @SecurityRequirement(name = "Bearer Authentication")
    @GetMapping("/song/{id}/lrc")
    suspend fun songLrc(
        @Parameter(description = "歌曲id", required = true, example = "25920721")
        @PathVariable id: Long,
        authentication: Authentication
    ): BaseVO<String> {
        val lrc = httpService.getSongLrc(id, authentication.cookie).lrc.lyric
        return BaseVO.success(lrc)
    }


    @Operation(summary = "喜欢音乐")
    @SecurityRequirement(name = "Bearer Authentication")
    @PostMapping("/song/{id}/like")
    suspend fun likeSong(
        @Parameter(description = "歌曲id", required = true, example = "25920721")
        @PathVariable id: Long,
        @Parameter(description = "是否喜欢", required = true)
        like: Boolean,
        authentication: Authentication
    ): BaseVO<String> {
        httpService.likeSong(id, like, authentication.cookie)
        return BaseVO.success(null)
    }

    @Operation(summary = "是否喜欢音乐")
    @SecurityRequirement(name = "Bearer Authentication")
    @GetMapping("/song/{id}/like")
    suspend fun isLikeSong(
        @Parameter(description = "歌曲id", required = true, example = "25920721")
        @PathVariable id: Long,
        authentication: Authentication
    ): BaseVO<Boolean> {
        val liked = httpService.isSongLiked("[$id]", authentication.cookie).ids.contains(id)
        return BaseVO.success(liked)
    }


    @Operation(summary = "最近播放的歌曲")
    @SecurityRequirement(name = "Bearer Authentication")
    @GetMapping("/song/recent")
    suspend fun recentSongs(
        authentication: Authentication
    ): BaseVO<List<Song>> {
        val list = httpService.recentSongs(authentication.cookie).data.list.map { it.data }
        return BaseVO.success(list)
    }
}