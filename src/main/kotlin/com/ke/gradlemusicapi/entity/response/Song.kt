package com.ke.gradlemusicapi.entity.response

import com.ke.gradlemusicapi.entity.document.Album
import com.ke.gradlemusicapi.entity.document.Artist
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Song(
	val id: Long,
	val name: String,
	@Json(name = "al")
	val album: Album,
	@Json(name = "ar")
	val artists: List<Artist>,
	/**
	 * mv的id，如果是0表示没有
	 */
	val mv: Long,
)
//
///**
// * 专辑
// */
//@JsonClass(generateAdapter = true)
//data class Album(
//    val id: Long,
//    val name: String,
//    @Json(name = "picUrl")
//    var imageUrl: String = "",
//)


