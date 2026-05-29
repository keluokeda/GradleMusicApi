package com.ke.gradlemusicapi.entity.response

import kotlinx.serialization.Serializable

@Serializable
data class UserDetailResponse(
    val code: Int,
    val level: Int,
    val listenSongs: Int,
    val createTime: Long,
    val createDays: Int,
    val mobileSign: Boolean,
    val pcSign: Boolean,
    val newUser: Boolean,
    val recallUser: Boolean,
    val adValid: Boolean,
    val peopleCanSeeMyPlayRecord: Boolean,
    val userPoint: UserPoint,
    val profile: Profile,
    val bindings: List<Binding>,
    val profileVillageInfo: ProfileVillageInfo
) {
    @Serializable
    data class UserPoint(
        val userId: Long,
        val balance: Int,
        val blockBalance: Int,
        val updateTime: Long,
        val version: Int,
        val status: Int
    )

    @Serializable
    data class Profile(
        val userId: Long,
        val nickname: String,
        val avatarUrl: String,
        val avatarImgId: Long,
        val avatarImgIdStr: String,
        val backgroundUrl: String,
        val backgroundImgId: Long,
        val backgroundImgIdStr: String,
        val signature: String,
        val createTime: Long,
        val birthday: Long,
        val gender: Int,
        val province: Int,
        val city: Int,
        val vipType: Int,
        val djStatus: Int,
        val authStatus: Int,
        val accountStatus: Int,
        val authority: Int,
        val userType: Int,
        val followed: Boolean,
        val mutual: Boolean,
        val followMe: Boolean,
        val defaultAvatar: Boolean,
        val blacklist: Boolean,
        val inBlacklist: Boolean,
        val follows: Int,
        val followeds: Int,
        val newFollows: Int,
        val playlistCount: Int,
        val eventCount: Int,
        val description: String,
        val detailDescription: String,
        val expertTags: List<String>? = null,
        val experts: Map<String, String>? = null,
        val remarkName: String? = null,
        val avatarDetail: String? = null,
        val followTime: Long? = null,
        val privacyItemUnlimit: PrivacyItemUnlimit? = null
    )

    @Serializable
    data class PrivacyItemUnlimit(
        val area: Boolean,
        val college: Boolean,
        val gender: Boolean,
        val age: Boolean,
        val villageAge: Boolean
    )

    @Serializable
    data class Binding(
        val id: Long,
        val userId: Long,
        val type: Int,
        val expiresIn: Long,
        val refreshTime: Long,
        val bindingTime: Long,
        val expired: Boolean,
        val url: String,
        val tokenJsonStr: String? = null
    )

    @Serializable
    data class ProfileVillageInfo(
        val title: String,
        val targetUrl: String,
        val imageUrl: String? = null
    )
}