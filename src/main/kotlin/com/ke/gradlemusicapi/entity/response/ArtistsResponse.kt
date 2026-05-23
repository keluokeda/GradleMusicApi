package com.ke.gradlemusicapi.entity.response

import kotlinx.serialization.Serializable

@Serializable
data class ArtistsResponse(
	val artist: Artist,
	val hotSongs: List<Song>
)
