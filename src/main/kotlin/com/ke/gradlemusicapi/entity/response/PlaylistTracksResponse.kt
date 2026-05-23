package com.ke.gradlemusicapi.entity.response

import kotlinx.serialization.Serializable

@Serializable
data class PlaylistTracksResponse(
    val songs: List<Song>
)
