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

	/**
	 * 歌曲时长
	 */
	@SerialName("dt")
	val duration: Long,

	/**
	 * 是否免费 0表示免费 1表示收费
	 */
	val fee: Int,

	/**
	 * 是否有版权
	 */
	val copyright: Int = 1,

	val level: String? = null
)
