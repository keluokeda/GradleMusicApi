package com.ke.gradlemusicapi.entity.response

import com.ke.gradlemusicapi.entity.document.Artist
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AlbumResponse(
    val songs: List<Song>,
    val album: AlbumData
)

@JsonClass(generateAdapter = true)
data class AlbumData(
    val name: String,
    val description: String?,
    val id: Long,
    val artist: Artist,
    val publishTime: Long,
    val picUrl: String,
    val artists: List<Artist>,
    val company: String
)

@JsonClass(generateAdapter = true)
data class NewAlbumListResponse(
    val albums: List<AlbumData> = emptyList()
)


