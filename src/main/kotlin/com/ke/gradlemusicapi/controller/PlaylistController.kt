package com.ke.gradlemusicapi.controller

import com.ke.gradlemusicapi.api.HttpService
import com.ke.gradlemusicapi.cookie
import com.ke.gradlemusicapi.entity.response.Playlist
import com.ke.gradlemusicapi.entity.response.User
import com.ke.gradlemusicapi.entity.vo.BaseListVO
import com.ke.gradlemusicapi.entity.vo.BaseVO
import com.ke.gradlemusicapi.entity.vo.PlaylistDetailVO
import com.ke.gradlemusicapi.user
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import io.swagger.v3.oas.annotations.tags.Tag
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.*

@Tag(name = "歌单")
@RestController
class PlaylistController(
    private val httpService: HttpService,
//    private val songService: SongService,
//    private val playlistService: PlaylistService
) {

    @Operation(summary = "添加歌曲到歌单")
    @SecurityRequirement(name = "Bearer Authentication")
    @PatchMapping("/user/current/playlist/{playlistId}/songs")
    suspend fun addToPlaylist(
        @PathVariable playlistId: Long,
        authentication: Authentication,
        songIds: Array<Long>
    ): BaseVO<Any> {

        httpService.addOrRemoveSongsToPlaylist(
            "add",
            playlistId,
            songIds.joinToString(","),
            cookie = authentication.cookie
        )

        return BaseVO.success(null)
    }

    @Operation(summary = "从歌单中删除歌曲")
    @SecurityRequirement(name = "Bearer Authentication")
    @DeleteMapping("/user/current/playlist/{playlistId}/songs/{songId}")
    suspend fun deleteSongFromPlaylist(
        @PathVariable playlistId: Long,
        @PathVariable songId: Long,
        authentication: Authentication,

        ): BaseVO<Any> {
        httpService.addOrRemoveSongsToPlaylist(
            "del",
            playlistId,
            songId.toString(),
            cookie = authentication.cookie
        )

        return BaseVO.success(null)
    }


    @Operation(summary = "获取当前用户的歌单")
    @SecurityRequirement(name = "Bearer Authentication")
    @GetMapping("/user/current/playlists")
    suspend fun currentUserPlaylists(
        authentication: Authentication
    ): BaseVO<List<Playlist>> {
        val cookie = authentication.cookie
        val userId = authentication.user.username.toLong()

        val list = httpService.getUserPlaylistList(userId, cookie = cookie).playlist

//        playlistRepository.saveAll(list)

        return BaseVO.success(list)
    }


    @Operation(summary = "获取某个用户的歌单")
    @SecurityRequirement(name = "Bearer Authentication")
    @GetMapping("/user/{userId}/playlists")
    suspend fun userPlaylists(
        @Parameter(description = "用户id", required = true, example = "8059600021")
        @PathVariable userId: Long,
        authentication: Authentication
    ): BaseVO<List<Playlist>> {
        val cookie = authentication.cookie

        val list = httpService.getUserPlaylistList(userId, cookie = cookie).playlist

//        playlistRepository.saveAll(list)


        return BaseVO.success(list)
    }

    @Operation(summary = "获取歌单详情")
    @SecurityRequirement(name = "Bearer Authentication")
    @GetMapping("/playlist/{id}")
    suspend fun playlistDetail(
        @Parameter(description = "歌单id", required = true, example = "8264272253")
        @PathVariable id: Long,
        authentication: Authentication
    ) = withContext(Dispatchers.IO) {
        val cookie = authentication.cookie


        val userId = authentication.user.username
        val playlist =
            httpService.getPlaylistDetail(id, cookie).playlist

        val songs = async {
            httpService.getPlaylistTracks(id, cookie).songs
        }

        val dynamic = async {
            httpService.getPlaylistDetailDynamic(id, cookie)
        }

        BaseVO.success(
            PlaylistDetailVO(
                playlist,
                songs.await(),
                dynamic.await(),
                canBook = playlist.creator.userId.toString() != userId
            )
        )

    }

    @Operation(summary = "删除歌单")
    @SecurityRequirement(name = "Bearer Authentication")
    @DeleteMapping("/playlist/{id}")
    suspend fun deletePlaylist(
        @Parameter(description = "歌单id", required = true, example = "8264272253")
        @PathVariable id: Long,
        authentication: Authentication
    ) = withContext(Dispatchers.IO) {
        val cookie = authentication.cookie

        httpService.deletePlaylist(id, cookie)

        BaseVO.success<Unit>(null)
    }

    /**
     * 取消收藏
     */
    @Operation(summary = "取消收藏歌单")
    @SecurityRequirement(name = "Bearer Authentication")
    @DeleteMapping("/playlist/{id}/subscribers")
    suspend fun deleteSubscription(
        @Parameter(description = "歌单id", required = true, example = "8264272253")
        @PathVariable id: Long,
        authentication: Authentication
    ) = withContext(Dispatchers.IO) {
        val cookie = authentication.cookie
        httpService.subscribePlaylist(id, 2, cookie)
        BaseVO.success(null)
    }


    @Operation(summary = "收藏歌单")
    @SecurityRequirement(name = "Bearer Authentication")
    @PostMapping("/playlist/{id}/subscribers")
    suspend fun createSubscription(
        @Parameter(description = "歌单id", required = true, example = "8264272253")
        @PathVariable id: Long,
        authentication: Authentication
    ) = withContext(Dispatchers.IO) {
        val cookie = authentication.cookie
        httpService.subscribePlaylist(id, 1, cookie)
        BaseVO.success(null)
    }

    @Operation(summary = "歌单收藏者")
    @SecurityRequirement(name = "Bearer Authentication")
    @GetMapping("/playlist/{id}/subscribers")
    suspend fun playlistSubscribers(
        @Parameter(description = "歌单id", required = true, example = "893126993")
        @PathVariable id: Long,
        authentication: Authentication,
        @RequestParam
        @Parameter(description = "第几页", required = true, example = "1")
        index: Int,
        @RequestParam
        @Parameter(description = "每页的数量", required = true, example = "50")
        size: Int
    ): BaseListVO<User> {

        val cookie = authentication.cookie
        val response = httpService.playlistSubscribers(id, limit = size, offset = (index - 1) * size, cookie = cookie)

//        playlistService.savePlaylistSubscribers(id, response.subscribers, index, size, index == 1)
        return BaseListVO(data = response.subscribers, hasMore = response.more)
    }
}