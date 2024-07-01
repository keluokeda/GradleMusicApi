package com.ke.gradlemusicapi.entity.response

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LrcResponse(
    val lrc: Lrc
)

@JsonClass(generateAdapter = true)
data class Lrc(
    val lyric: String
)
