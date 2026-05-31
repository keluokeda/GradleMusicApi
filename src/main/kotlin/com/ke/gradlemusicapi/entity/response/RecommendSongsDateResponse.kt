package com.ke.gradlemusicapi.entity.response

import kotlinx.serialization.Serializable

@Serializable
data class RecommendSongsDateResponse(
    val code: Int,
    val data: Data
) {
    @Serializable
    data class Data(
        val dates: List<String> = emptyList(),
//        val purchaseUrl: String,
        val description: String? = null,
        val noHistoryMessage: String? = null,
        val songs: List<Song>? = null
    )
}
