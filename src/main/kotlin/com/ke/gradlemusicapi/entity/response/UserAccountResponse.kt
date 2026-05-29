package com.ke.gradlemusicapi.entity.response

import kotlinx.serialization.Serializable

@Serializable
data class UserAccountResponse(
    val code: Int,
    val account: UserAccount,
    val profile: UserProfile
) {

    @Serializable
    data class UserAccount(
        val id: Long,
        val userName: String,
        val type: Int,
        val status: Int,
        val createTime: Long,
        val vipType: Int,
        val ban: Int,
        val anonimousUser: Boolean,
        val paidFee: Boolean
    )

    @Serializable
    data class UserProfile(
        val userId: Long,
        val userType: Int,
        val nickname: String,
        val avatarUrl: String,
        val avatarImgId: Long,
        val backgroundUrl: String,
        val backgroundImgId: Long,
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
        val followed: Boolean,
        val mutual: Boolean,
        val defaultAvatar: Boolean,
        val lastLoginTime: Long,
        val lastLoginIP: String,
        val description: String? = null,
        val detailDescription: String? = null,
        val expertTags: List<String>? = null,
        val experts: Map<String, String>? = null,
        val remarkName: String? = null,
        val avatarDetail: String? = null
    )
}
