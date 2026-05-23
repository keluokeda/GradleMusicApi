package com.ke.gradlemusicapi.entity.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PlaylistTopResponse(
	val playlists: List<Playlist>,
	val more: Boolean,
	@SerialName("cat")
	val category: String,
)
