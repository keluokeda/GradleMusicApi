package com.ke.gradlemusicapi.entity.response

import com.ke.gradlemusicapi.entity.response.Playlist
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PlaylistTopResponse(
	val playlists: List<Playlist>,
	val more: Boolean,
	@Json(name = "cat")
    val category: String,
)
