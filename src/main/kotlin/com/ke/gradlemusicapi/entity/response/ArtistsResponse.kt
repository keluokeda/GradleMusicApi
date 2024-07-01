package com.ke.gradlemusicapi.entity.response

import com.ke.gradlemusicapi.entity.document.Artist
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ArtistsResponse(
	val artist: Artist,
	val hotSongs: List<Song>
)
