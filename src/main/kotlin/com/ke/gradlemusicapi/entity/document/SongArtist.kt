package com.ke.gradlemusicapi.entity.document

import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document("song_artist")
data class SongArtist(
	val id: String?,
	@Field("song_id")
	val songId: Long,
	@Field("artist_id")
	val artistId: Long
)
