package com.ke.gradlemusicapi.entity.response

import kotlinx.serialization.Serializable

@Serializable
data class MvAllResponse(
    val data: List<Mv>,
    val hasMore: Boolean,
    val code: Int
)


@Serializable
data class Mv(
    val id: Long,
    val cover: String,
    val name: String,
    val playCount: Int,
    val artistName: String,
    val duration: Int,
    val artists: List<Artist>
)


