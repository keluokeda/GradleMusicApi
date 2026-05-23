package com.ke.gradlemusicapi.entity.response

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val userId: Long,
    val signature: String? = "",
    val nickname: String,
    val followed: Boolean,
    val avatarUrl: String
)
