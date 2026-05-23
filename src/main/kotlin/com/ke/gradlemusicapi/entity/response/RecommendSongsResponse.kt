package com.ke.gradlemusicapi.entity.response

import kotlinx.serialization.Serializable

@Serializable
data class RecommendSongsResponse(
    val code: Int,
    val data: RecommendSongsData?
)

@Serializable
data class RecommendSongsData(
    val dailySongs: List<Song>
)

