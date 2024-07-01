package com.ke.gradlemusicapi.entity.vo

import com.ke.gradlemusicapi.entity.document.Artist
import com.ke.gradlemusicapi.entity.response.Song

data class AlbumDetailVO(
	val isSub: Boolean,
	val songs: List<Song>,
	val name: String,
	val description: String?,
	val id: Long,
	val picUrl: String,
	val artists: List<Artist>,
	val image: String
)
