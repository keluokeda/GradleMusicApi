package com.ke.gradlemusicapi.entity.document

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class User(
	@Id
	val id: Long,
	val signature: String,
	val nickname: String,
	val avatarUrl: String
)
