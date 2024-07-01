package com.ke.gradlemusicapi.entity.response

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserFollowsResponse(
	val more: Boolean,
	/**
	 * 关注的人
	 */
	val follow: List<User> = emptyList(),
	/**
	 * 粉丝
	 */
	val followeds: List<User> = emptyList()
)
