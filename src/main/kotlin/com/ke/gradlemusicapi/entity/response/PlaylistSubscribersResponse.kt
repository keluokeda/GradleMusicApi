package com.ke.gradlemusicapi.entity.response

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PlaylistSubscribersResponse(
	val subscribers: List<User>,
	val more: Boolean
)
