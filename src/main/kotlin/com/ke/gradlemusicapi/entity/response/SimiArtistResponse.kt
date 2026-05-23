package com.ke.gradlemusicapi.entity.response

import kotlinx.serialization.Serializable

@Serializable
data class SimiArtistResponse(
	val artists: List<Artist>,
)
