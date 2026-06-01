package com.ke.gradlemusicapi.entity.response

import kotlinx.serialization.Serializable

@Serializable
data class ArtistHotSongsResponse(
    val songs: List<Song>
)
