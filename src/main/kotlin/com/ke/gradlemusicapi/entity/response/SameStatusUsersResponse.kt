package com.ke.gradlemusicapi.entity.response

import kotlinx.serialization.Serializable

@Serializable
data class SameStatusUsersResponse(
    val code: Int,
    val message: String,
    val data: Data
) {
    @Serializable
    data class Data(
        val rcmdTitle: String,
        val onlyShowState: Boolean,
        val statusContentDTO: StatusContent,
        val userRcmdInfoVOList: List<UserRcmdInfo>
    )

    @Serializable
    data class StatusContent(
        val type: String,
        val iconUrl: String,
        val content: String,
        val canEdit: Boolean,
        val actionUrl: String? = null,
        val vistorUrl: String? = null,
        val desc: String? = null
    )

    @Serializable
    data class UserRcmdInfo(
        val userId: Long,
        val nickName: String,
        val avatarUrl: String,
        val actionUrl: String,
        val statusContentDTO: StatusContent,
        val tagRcmdVOList: List<TagRcmd>,
        val rcmdWords: String? = null,
//        val identityInfoDTO: String? = null
    )

    @Serializable
    data class TagRcmd(
        val name: String,
        val match: Boolean,
        val id: Long? = null
    )
}
