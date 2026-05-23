package com.ke.gradlemusicapi.entity.response

import kotlinx.serialization.Serializable

@Serializable
data class PlaylistSubscribersResponse(
	val subscribers: List<User>,
	val more: Boolean
)
