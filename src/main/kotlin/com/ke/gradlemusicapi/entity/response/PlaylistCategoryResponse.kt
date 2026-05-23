package com.ke.gradlemusicapi.entity.response

import kotlinx.serialization.Serializable

@Serializable
data class PlaylistCategoryResponse(
    val all: PlaylistCategory,
    val sub: List<PlaylistCategory>
)

@Serializable
data class PlaylistCategory(
    val name: String,
    val hot: Boolean
)
