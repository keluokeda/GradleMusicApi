package com.ke.gradlemusicapi.entity.response

import kotlinx.serialization.Serializable

@Serializable
data class LoginQRKeyResponse(
    val data: LoginQRKeyData? = null
)

@Serializable
data class LoginQRKeyData(
    val unikey: String? = null
)
