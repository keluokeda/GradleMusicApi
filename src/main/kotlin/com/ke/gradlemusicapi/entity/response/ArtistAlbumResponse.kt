package com.ke.gradlemusicapi.entity.response

import com.ke.gradlemusicapi.entity.document.Album
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ArtistAlbumResponse(
    val hotAlbums: List<Album>,
    val more: Boolean,
    val code: Int
)
