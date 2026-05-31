package com.ke.gradlemusicapi.entity.response

import kotlinx.serialization.Serializable

@Serializable
data class PlaylistsResponse(
    val playlists: List<Playlist>,
    val lasttime: Long,
    val more: Boolean
)
