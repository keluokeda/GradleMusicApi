package com.ke.gradlemusicapi.entity.document

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document("playlist_song")
data class PlaylistSong(
	@Id
	val id: String,
	@Field("playlist_id")
	val playlistId: Long,
	@Field("song_id")
	val songId: Long,
	val index: Int
)
