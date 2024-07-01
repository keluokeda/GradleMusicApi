package com.ke.gradlemusicapi.entity.response

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PlaylistDynamicResponse(
	/**
	 * 分享次数
	 */
	val shareCount: Long,
	/**
	 * 播放次数
	 */
	val playCount: Long,
	/**
	 * 订阅数量
	 */
	val bookedCount: Long,
	/**
	 * 是否订阅了
	 */
	val subscribed: Boolean,

	/**
	 * 评论数量
	 */
	val commentCount: Long
)
