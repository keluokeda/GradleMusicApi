package com.ke.gradlemusicapi.entity.response

import kotlinx.serialization.Serializable

@Serializable
data class CodeResponse(
    val code: Int
) {
    val success: Boolean
        get() = code == 200
}
