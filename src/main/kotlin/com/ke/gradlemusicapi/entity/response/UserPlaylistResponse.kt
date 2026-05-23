package com.ke.gradlemusicapi.entity.response

import kotlinx.serialization.Serializable

@Serializable
data class UserPlaylistResponse(
	val playlist: List<Playlist>,
	val more: Boolean,
	val code: Int
)
