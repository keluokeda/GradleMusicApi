package com.ke.gradlemusicapi.entity.document

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

/**
 * 歌手
 */
@JsonClass(generateAdapter = true)
@Document
data class Artist(
	@Id
	val id: Long,
	val name: String,
	@Json(name = "img1v1Url")
	val avatar: String?,
)
