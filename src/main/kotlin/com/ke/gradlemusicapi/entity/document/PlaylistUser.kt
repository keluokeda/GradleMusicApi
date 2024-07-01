package com.ke.gradlemusicapi.entity.document

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("playlist_user")
data class PlaylistUser(
	@Id
	val id: String? = null,
	val playlistId: Long,
	val userId: Long,
	/**
	 * 1表示创建，2表示收藏
	 */
	val type: Int
)
