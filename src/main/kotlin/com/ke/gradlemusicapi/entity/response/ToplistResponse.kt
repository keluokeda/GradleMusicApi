package com.ke.gradlemusicapi.entity.response

import kotlinx.serialization.Serializable

@Serializable
data class ToplistResponse(
    val list: List<ToplistItem>
)

@Serializable
data class ToplistItem(
    val id: Long,
    val name: String,
    val description: String?,
    val coverImgUrl: String
)
