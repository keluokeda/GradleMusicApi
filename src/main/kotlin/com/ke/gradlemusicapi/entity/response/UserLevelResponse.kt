package com.ke.gradlemusicapi.entity.response

import kotlinx.serialization.Serializable

@Serializable
data class UserLevelResponse(
    val code: Int,
    val full: Boolean,
    val data: UserLevelData
) {

    @Serializable
    data class UserLevelData(
        val userId: Long,
        val level: Int,
        val info: String,
        val progress: Double,
        val nowPlayCount: Int,
        val nextPlayCount: Int,
        val nowLoginCount: Int,
        val nextLoginCount: Int
    )
}