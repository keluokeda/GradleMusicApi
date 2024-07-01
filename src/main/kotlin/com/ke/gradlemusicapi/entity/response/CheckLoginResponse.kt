package com.ke.gradlemusicapi.entity.response

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CheckLoginResponse(
    val code: Int,
    val message: String,
    val cookie: String,
)
