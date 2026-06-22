package com.ke.gradlemusicapi.entity.response

import kotlinx.serialization.Serializable

@Serializable
data class RecentSongsResponse(
    val code: Int,
    val data: RecentSongsData
) {
    @Serializable
    data class RecentSongsData(
        val total: Int,
        val list: List<RecentSongItem>
    )

    @Serializable
    data class RecentSongItem(
        val data: Song
    )

}
