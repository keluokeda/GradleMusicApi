package com.ke.gradlemusicapi.controller


import com.ke.gradlemusicapi.api.HttpService
import com.ke.gradlemusicapi.cookie
import com.ke.gradlemusicapi.entity.response.Artist
import com.ke.gradlemusicapi.entity.response.ArtistFansResponse
import com.ke.gradlemusicapi.entity.response.User
import com.ke.gradlemusicapi.entity.vo.ArtistDetailVO
import com.ke.gradlemusicapi.entity.vo.BaseListVO
import com.ke.gradlemusicapi.entity.vo.BaseVO
import com.ke.gradlemusicapi.entity.vo.MvVO
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import io.swagger.v3.oas.annotations.tags.Tag
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@Tag(name = "歌手")
@RestController
class ArtistController(private val httpService: HttpService) {

    @Operation(summary = "歌手粉丝")
    @SecurityRequirement(name = "Bearer Authentication")
    @GetMapping("/artist/{id}/fans")
    suspend fun artistFans(
        @PathVariable id: Long,
        index: Int,
        size: Int,
        authentication: Authentication
    ): BaseVO<List<ArtistFansResponse>> {
        val response =
            httpService.artistFans(id, offset = (index - 1) * size, limit = size, cookie = authentication.cookie)

        return BaseVO.success(response.data!!)
    }


    @Operation(summary = "获取歌手列表")
    @SecurityRequirement(name = "Bearer Authentication")
    @GetMapping("/artists")
    suspend fun artists(
        type: Int = -1,
        area: Int = -1,
        index: Int = 1,
        size: Int = 20,
        authentication: Authentication
    ): BaseListVO<Artist> {
        val response = httpService.getArtistList(type, area, size, (index - 1) * size, authentication.cookie)
        return BaseListVO(data = response.artists, hasMore = response.more)
    }

    @Operation(summary = "获取歌手详情")
    @SecurityRequirement(name = "Bearer Authentication")
    @GetMapping("/artist/{id}")
    suspend fun getArtistDetail(
        @Parameter(description = "歌手id", required = true, example = "10577")
        @PathVariable id: Long, authentication: Authentication
    ) = withContext(Dispatchers.IO) {
        val cookie = authentication.cookie

//        httpService.artistFans(id,cookie=cookie)

        val detail = httpService.artistDetail(id, cookie).data!!
        val fansCount = httpService.artistFansCount(id, cookie).data!!

        val hotSongs = httpService.artistHotSongs(id, cookie).songs

        val artist =
            httpService.getArtists(id, cookie).artist
        val simiArtists = async {
            httpService.getSimiArtist(id, authentication.cookie)
        }
        val mvs = async {
            httpService.getArtistMv(id, 1000, cookie)
        }
        val albums = async {
            httpService.getArtistAlbums(id, 1000, cookie)
        }

        return@withContext BaseVO.success(
            ArtistDetailVO(
                artist,
                hotSongs,
                detail,
                simiArtists.await().artists,
                mvs.await().mvs.map {
                    MvVO(it.id, it.name, it.image)
                },
                albums.await().hotAlbums,
                fansCount = fansCount.fansCnt,
                followed = fansCount.isFollow
            )
        )
    }
}