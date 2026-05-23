package com.ke.gradlemusicapi.entity.response

import kotlinx.serialization.Serializable

@Serializable
data class PlaylistTagsResponse(
    val tags: List<PlaylistTag>
)

@Serializable
data class PlaylistTag(
    val name: String,
    val hot: Boolean,
    val id: Long
)
