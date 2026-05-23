package com.ke.gradlemusicapi.entity.response

import kotlinx.serialization.Serializable

@Serializable
data class ArtistAlbumResponse(
    val hotAlbums: List<Album>,
    val more: Boolean,
    val code: Int
)
