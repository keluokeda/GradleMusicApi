package com.ke.gradlemusicapi.entity.document

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@JsonClass(generateAdapter = true)
@Document
data class Album(
	@Id
	val id: Long,
	val name: String,
	@Json(name = "picUrl")
	@Field("image_url")
	var imageUrl: String = "",
)
