package com.ke.gradlemusicapi.entity.vo

import com.ke.gradlemusicapi.entity.response.Song

data class SongDetailVO(
	val song: Song,
	val url: String?
)
