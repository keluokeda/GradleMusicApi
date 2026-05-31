package com.ke.gradlemusicapi.entity.response

import kotlinx.serialization.Serializable

@Serializable
data class TopArtistsResponse(
    val artists: List<Artist>
)
