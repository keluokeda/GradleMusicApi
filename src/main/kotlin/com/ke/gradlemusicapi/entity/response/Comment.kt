package com.ke.gradlemusicapi.entity.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Comment(
	val commentId: Long = 0,
	val user: User,
	val content: String?,
	@SerialName("timeStr")
	val timeString: String = "",
	val time: Long = 0,
	val likedCount: Int = 0,
	val ipLocation: IpLocation,
	val owner: Boolean = false,
	val liked: Boolean = false,
	val parentCommentId: Long = 0L,
	/**
	 * 子评论数
	 */
	val replyCount: Int = 0
)

@Serializable
data class IpLocation(
	val location: String = ""
)
