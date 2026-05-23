package com.ke.gradlemusicapi.entity.response

import kotlinx.serialization.Serializable

@Serializable
data class ArtistDescResponse(
    val briefDesc: String,
    val introduction: List<ArtistIntroduce>,
    val code: Int
)

@Serializable
data class ArtistIntroduce(
    val ti: String,
    val txt: String
)
