package com.ke.gradlemusicapi.entity.response

import kotlinx.serialization.Serializable

@Serializable
data class LoginStatusResponse(
    val data: LoginStatusData? = null
)

@Serializable
data class LoginStatusData(
    val profile: LoginStatusProfile? = null
)

@Serializable
data class LoginStatusProfile(
    val userId: Long
)
