package com.ke.gradlemusicapi.entity.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArtistMvResponse(
    val mvs: List<ArtistMv>
)

@Serializable
data class ArtistMv(
	val id: Long,
	val name: String,
	val status: Int,
	val artist: Artist,
	@SerialName("imgurl16v9")
	val image: String,
	val artistName: String,
	val duration: Int,
	val playCount: Int,
	val publishTime: String
)
