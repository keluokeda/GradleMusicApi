package com.ke.gradlemusicapi.entity.response

import com.ke.gradlemusicapi.entity.document.Artist
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ArtistListResponse(
	val artists: List<Artist>,
	val more: Boolean,
	val code: Int
)

//@JsonClass(generateAdapter = true)
//data class Artist(
//	val id: Long,
//	val name: String,
//	@Json(name = "img1v1Url")
//	val avatar: String? = null,
//	/**
//	 * 是否关注
//	 */
//	val followed: Boolean = false,
//)
