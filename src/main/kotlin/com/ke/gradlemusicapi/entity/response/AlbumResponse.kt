package com.ke.gradlemusicapi.entity.response

import kotlinx.serialization.Serializable

@Serializable
data class AlbumResponse(
    val songs: List<Song>,
    val album: AlbumData
)

@Serializable
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

@Serializable
data class NewAlbumListResponse(
    val albums: List<AlbumData> = emptyList()
)


