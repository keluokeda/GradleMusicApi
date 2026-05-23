package com.ke.gradlemusicapi.entity.response

import kotlinx.serialization.Serializable

@Serializable
data class HighQualityPlaylistsResponse(
    val playlists: List<Playlist>,
    val more: Boolean,
)
