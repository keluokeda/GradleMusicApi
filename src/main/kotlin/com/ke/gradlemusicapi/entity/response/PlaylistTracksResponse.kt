package com.ke.gradlemusicapi.entity.response

import kotlinx.serialization.Serializable

@Serializable
data class PlaylistTracksResponse(
	val songs: List<Song>,
	val privileges: List<Privilege>
)

@Serializable
data class Privilege(
	val id: Long,
	val maxBrLevel: String? = null
)