package com.ke.gradlemusicapi.entity.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RecommendVideosResponse(
    val datas: List<RecommendVideoItem>,
    val msg: String,
    val hasmore: Boolean,
    val code: Int
)

@Serializable
data class RecommendVideoItem(
    val type: Int,
    val displayed: Boolean,
    val alg: String,
    val extAlg: String? = null,
    val data: VideoData
)

@Serializable
data class VideoData(
    val alg: String,
    val scm: String,
    val threadId: String,
    val coverUrl: String,
    val height: Int,
    val width: Int,
    val title: String,
    val description: String? = null,
    val commentCount: Int,
    val shareCount: Int,
    val resolutions: List<VideoResolution>,
    val creator: VideoCreator,
    val urlInfo: VideoUrlInfo,
    val videoGroup: List<VideoGroup>,
    val previewUrl: String? = null,
    val previewDurationms: Int,
    val hasRelatedGameAd: Boolean,
    val markTypes: List<Int>? = null,
    val relateSong: List<VideoRelateSong>,
    val vid: String,
    val durationms: Long,
    val playTime: Long,
    val praisedCount: Int,
    val praised: Boolean,
    val subscribed: Boolean
)

@Serializable
data class VideoResolution(
    val resolution: Int,
    val size: Long
)

@Serializable
data class VideoCreator(
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
    val experts: Map<String, String>? = null,
    val djStatus: Int,
    val followed: Boolean,
    val mutual: Boolean,
    val remarkName: String? = null,
    val authority: Int
)

@Serializable
data class VideoUrlInfo(
    val id: String,
    val url: String,
    val size: Long,
    val validityTime: Int,
    val needPay: Boolean,
    val r: Int
)

@Serializable
data class VideoGroup(
    val id: Int,
    val name: String,
    val alg: String? = null
)

@Serializable
data class VideoRelateSong(
    val id: Long,
    val name: String,
    @SerialName("ar")
    val artists: List<Artist>,
    @SerialName("al")
    val album: Album,
    val dt: Int,
    val fee: Int,
    val mv: Long,
    val privilege: VideoSongPrivilege? = null
)

@Serializable
data class VideoSongPrivilege(
    val id: Long,
    val fee: Int,
    val payed: Int,
    val st: Int,
    val pl: Int,
    val dl: Int,
    val sp: Int,
    val cp: Int,
    val subp: Int,
    val cs: Boolean,
    val maxbr: Int,
    val fl: Int,
    val toast: Boolean,
    val flag: Long,
    val preSell: Boolean
)