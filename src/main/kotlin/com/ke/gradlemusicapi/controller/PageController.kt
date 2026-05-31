package com.ke.gradlemusicapi.controller

import com.ke.gradlemusicapi.api.HttpService
import com.ke.gradlemusicapi.cookie
import com.ke.gradlemusicapi.entity.vo.BaseVO
import com.ke.gradlemusicapi.entity.vo.MineVO
import com.ke.gradlemusicapi.entity.vo.RecommendVO
import com.ke.gradlemusicapi.user
import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class PageController(private val httpService: HttpService) {

    @GetMapping("/mine")
    suspend fun mine(
        authentication: Authentication

    ): BaseVO<MineVO> {
        val cookie = authentication.cookie
        httpService.sameStatusUsers(cookie)
//        httpService.updateUserStatus("emo","EMOJI_TEXT_15","https://p6.music.126.net/obj/wonDlsKUwrLClGjCm8Kx/12020914951/8137/620d/b2fc/b7f0189889945b8f77275e57891197da.png",null,cookie)

        return BaseVO.success(
            MineVO(
                userDetail = httpService.userDetail(authentication.user.username, cookie),
                userLevel = httpService.userLevel(cookie = cookie),
                userAccount = httpService.userAccount(cookie),
//                supportStatusList = httpService.userSupportStatus(cookie).data,
                currentStatus = httpService.userStatus(userId = authentication.user.username, cookie).data.content

            )
        )

    }

    @GetMapping("/recommend")
    suspend fun recommend(
        authentication: Authentication
    ): BaseVO<RecommendVO> {
        val cookie = authentication.cookie

//        httpService.topPlaylists(cookie)

        return BaseVO.success(
            RecommendVO(
                videos = httpService.recommendVideos(cookie).datas,
                playlists = httpService.recommendPlaylists(cookie).recommend,
                songs = httpService.recommendSongs(cookie).data!!.dailySongs,
                newSongs = httpService.recommendNewSongs(cookie).result,
                toplistItems = httpService.toplist(cookie).list,
                topArtists = httpService.topArtists(cookie).artists
            )
        )
    }
}