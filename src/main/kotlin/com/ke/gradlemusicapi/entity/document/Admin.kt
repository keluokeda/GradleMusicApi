package com.ke.gradlemusicapi.entity.document

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Admin(
	@Id
	val account: String,
	val password: String,
	val admin: Boolean
)
