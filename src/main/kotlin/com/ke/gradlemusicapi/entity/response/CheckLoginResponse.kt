package com.ke.gradlemusicapi.entity.response

import kotlinx.serialization.Serializable

@Serializable
data class CheckLoginResponse(
    val code: Int,
    val message: String,
    val cookie: String,
)
