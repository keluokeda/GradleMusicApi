package com.ke.gradlemusicapi.entity.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Song(
	val id: Long,
	val name: String,
	@SerialName("al")
	val album: Album,
	@SerialName("ar")
	val artists: List<Artist>,
	/**
	 * mv的id，如果是0表示没有
	 */
	val mv: Long,
)
