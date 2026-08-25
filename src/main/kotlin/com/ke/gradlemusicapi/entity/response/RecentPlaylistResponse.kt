package com.ke.gradlemusicapi.entity.response

import kotlinx.serialization.Serializable

@Serializable
data class RecentPlaylistResponse(
    val code: Int,
    val data: Data
) {
    @Serializable
    data class Data(
        val total: Int,
        val list: List<Item>
    )

    @Serializable
    data class Item(
        val playTime: Long,
        val data: PlaylistItem
    )

    @Serializable
    data class PlaylistItem(
        val id: Long,
        val name: String,
        val coverImgUrl: String
    )

}
