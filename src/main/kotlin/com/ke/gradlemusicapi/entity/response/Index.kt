package com.ke.gradlemusicapi.entity.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Artist(

    val id: Long,
    val name: String,
    @SerialName("img1v1Url")
    val avatar: String? = null,
)

//data class Song(
//    val id: Long,
//    val name: String,
//    val mv: Long,
//    val album: Album,
//    val artists: List<Artist> = emptyList()
//)
@Serializable
data class Album(

    val id: Long,
    val name: String,
    @SerialName("picUrl")
    var imageUrl: String = "",
)