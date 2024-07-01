package com.ke.gradlemusicapi.entity.response

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CodeResponse(
    val code: Int
) {
    val success: Boolean
        get() = code == 200
}
