package com.ke.gradlemusicapi.entity.response

import com.ke.gradlemusicapi.entity.document.Artist
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SimiArtistResponse(
	val artists: List<Artist>,
)
