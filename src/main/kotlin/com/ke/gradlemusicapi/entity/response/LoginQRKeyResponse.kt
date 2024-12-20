package com.ke.gradlemusicapi.entity.response

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LoginQRKeyResponse(
    val data: LoginQRKeyData? = null
)

@JsonClass(generateAdapter = true)
data class LoginQRKeyData(
    val unikey: String? = null
)
