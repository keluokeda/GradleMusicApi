package com.ke.gradlemusicapi.entity.response

import kotlinx.serialization.Serializable

@Serializable
data class LoginQRCreateResponse(
    val data: LoginQRCreateData? = null
)

@Serializable
data class LoginQRCreateData(
    val qrurl: String? = null
)