package com.ke.gradlemusicapi.entity.response

import kotlinx.serialization.Serializable

@Serializable
data class LrcResponse(
    val lrc: Lrc
)

@Serializable
data class Lrc(
    val lyric: String
)
