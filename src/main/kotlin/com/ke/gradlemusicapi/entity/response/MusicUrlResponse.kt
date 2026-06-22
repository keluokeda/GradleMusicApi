package com.ke.gradlemusicapi.entity.response

import kotlinx.serialization.Serializable


@Serializable
data class MusicUrlResponse(
    val data: List<SongUrl>
)

@Serializable
data class MusicDownloadUrlResponse(
    val data: SongUrl?
)

@Serializable
data class SongUrl(
    val url: String?,
    val level: String
)