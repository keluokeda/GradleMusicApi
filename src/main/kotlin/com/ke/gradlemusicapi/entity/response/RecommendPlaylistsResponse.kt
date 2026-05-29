package com.ke.gradlemusicapi.entity.response

import kotlinx.serialization.Serializable

@Serializable
data class RecommendPlaylistsResponse(
    val code: Int,
    val featureFirst: Boolean,
    val haveRcmdSongs: Boolean,
    val recommend: List<RecommendPlaylist>
)

@Serializable
data class RecommendPlaylist(
    val id: Long,
    val type: Int,
    val name: String,
    val copywriter: String,
    val picUrl: String,
    val playcount: Long,
    val createTime: Long,
    val creator: RecommendPlaylistCreator,
    val trackCount: Int,
    val userId: Long,
    val alg: String
)

@Serializable
data class RecommendPlaylistCreator(
    val userId: Long,
    val nickname: String,
    val avatarUrl: String,
    val backgroundUrl: String,
    val avatarImgId: Long,
    val avatarImgIdStr: String,
    val backgroundImgId: Long,
    val backgroundImgIdStr: String,
    val vipType: Int,
    val province: Int,
    val city: Int,
    val birthday: Long,
    val accountStatus: Int,
    val authStatus: Int,
    val userType: Int,
    val gender: Int,
    val detailDescription: String,
    val description: String,
    val signature: String,
    val defaultAvatar: Boolean,
    val expertTags: List<String>? = null,
    val djStatus: Int,
    val followed: Boolean,
    val mutual: Boolean,
    val remarkName: String? = null,
    val authority: Int
)