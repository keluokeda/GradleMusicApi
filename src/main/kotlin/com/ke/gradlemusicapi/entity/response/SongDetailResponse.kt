package com.ke.gradlemusicapi.entity.response

import kotlinx.serialization.Serializable

@Serializable
data class SongDetailResponse(
    val songs: List<Song>
)
