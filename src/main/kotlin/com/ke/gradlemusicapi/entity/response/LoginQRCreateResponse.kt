package com.ke.gradlemusicapi.entity.response

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LoginQRCreateResponse(
    val data: LoginQRCreateData? = null
)

@JsonClass(generateAdapter = true)
data class LoginQRCreateData(
    val qrurl: String? = null
)