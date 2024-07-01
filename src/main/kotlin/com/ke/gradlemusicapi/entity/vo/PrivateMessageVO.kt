package com.ke.gradlemusicapi.entity.vo

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonIgnore
import java.util.Date

data class PrivateMessageVO(
	val id: Long,
	val targetUserId: Long,
	val targetNickname: String,
	val targetUserAvatar: String,
	@JsonFormat(pattern = "MM-dd hh:mm", timezone = "GMT+8")
	val date: Date,
	val content: String,
	@JsonIgnore
	val lastMessage: String
)
