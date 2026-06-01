package com.ke.gradlemusicapi.entity.response

import kotlinx.serialization.Serializable

@Serializable
data class CodeDataResponse<T>(
    val code: Int,
    val data: T?
)
