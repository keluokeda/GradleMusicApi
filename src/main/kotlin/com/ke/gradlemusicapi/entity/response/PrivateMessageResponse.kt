package com.ke.gradlemusicapi.entity.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PrivateMessageResponse(
	@SerialName("msgs")
	val list: List<PrivateMessage>,
	val more: Boolean,
	val code: Int,
	@SerialName("newMsgCount")
	val newCount: Int
)

@Serializable
data class PrivateMessage(
	@SerialName("lastMsg")
	val lastMessage: String,
	@SerialName("lastMsgTime")
	val time: Long,
	val fromUser: User,
	val toUser: User,
	@SerialName("lastMsgId")
	val id: Long? = 0
)
