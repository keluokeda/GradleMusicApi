package com.ke.gradlemusicapi.entity.response

import kotlinx.serialization.Serializable

@Serializable
data class UserCurrentStatusResponse(
    val data:UserCurrentStatus
){
    @Serializable
    data class UserCurrentStatus(
        val id: Long? = null,
        val userId: Long? = null,
        val status: Int? = null,
        val content: UserSupportStatus? = null,
        val editLimit: Boolean? = null
    )
}
