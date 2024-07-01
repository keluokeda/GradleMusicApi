package com.ke.gradlemusicapi.entity.document

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.DocumentReference

@Document
class Song(
	@Id
	val id: Long,
	val name: String,
	val mv: Long,
	val album: Album,
	val artists: List<Artist> = emptyList()
)
