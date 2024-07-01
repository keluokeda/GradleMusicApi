package com.ke.gradlemusicapi.entity.response

import com.ke.gradlemusicapi.entity.document.Artist
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ArtistMvResponse(
    val mvs: List<ArtistMv>
)

@JsonClass(generateAdapter = true)
data class ArtistMv(
	val id: Long,
	val name: String,
	val status: Int,
	val artist: Artist,
	@Json(name = "imgurl16v9")
    val image: String,
	val artistName: String,
	val duration: Int,
	val playCount: Int,
	val publishTime: String
)
