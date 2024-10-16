package com.ke.gradlemusicapi.entity.response

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RecommendSongsResponse(
    val code: Int,
    val data: RecommendSongsData?
)

@JsonClass(generateAdapter = true)
data class RecommendSongsData(
    val dailySongs: List<Song>
)

