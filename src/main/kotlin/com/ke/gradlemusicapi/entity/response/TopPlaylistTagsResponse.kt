package com.ke.gradlemusicapi.entity.response

import kotlinx.serialization.Serializable

@Serializable
data class TopPlaylistTagsResponse(
    val tags: List<Tag>
){

    @Serializable
    data class Tag(
        val name: String
    )
}
