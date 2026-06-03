package com.ke.gradlemusicapi.entity.vo

import com.ke.gradlemusicapi.entity.response.EventsResponse
import com.ke.gradlemusicapi.entity.response.User
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

data class EventVO(
    val user: User,
    val eventTime: Long,
    val pics: List<String>,
    val bottomTags: List<EventTag>,
    val eventJson: EventJson,
) {


    data class EventTag(
        val id: String,
        val name: String
    )

    @Serializable
    data class EventJson(
        val title: String = "",
        @SerialName("msg")
        val message: String,
        val song: EventSong? = null,
        val album: EventAlbumRoot? = null,
        val playlist: EventPlaylist? = null,
    )

    @Serializable
    data class EventPlaylist(
        val id: String,
        val name: String,
        val coverImgUrl: String,
        val creator: User
    )

    @Serializable
    data class EventAlbumRoot(
        val artist: EventArtist,
        val name: String,
        val type: String,
        val picUrl: String,
        val id: Long,
    )

    @Serializable
    data class EventSong(
        val name: String,
        val id: Long,
        val artists: List<EventArtist>,
        val album: EventAlbum
    )

    @Serializable
    data class EventArtist(
        val name: String,
        val id: Long,
        @SerialName("img1v1Url")
        val imageUrl: String,
    )

    @Serializable
    data class EventAlbum(
        val name: String,
        val id: Long,
        val type: String,
        val picUrl: String,
    )
}

private val json = Json {
    ignoreUnknownKeys = true
    coerceInputValues = true
    isLenient = true


}

fun EventsResponse.Event.convert(): EventVO {
    return EventVO(
        user = user,
        eventTime = eventTime,
        pics = pics.map { it.originUrl },
        bottomTags = bottomActivityInfos.map { EventVO.EventTag(it.id, it.name) },
        eventJson = com.ke.gradlemusicapi.entity.vo.json.decodeFromString(json)
    )
}