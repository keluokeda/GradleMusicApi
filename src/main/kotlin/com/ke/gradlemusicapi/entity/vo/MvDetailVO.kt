package com.ke.gradlemusicapi.entity.vo

import com.ke.gradlemusicapi.entity.document.Artist

data class MvDetailVO(
	val id: Long,
	val name: String,
	val artists: List<Artist>,
	val url: String,
	val cover: String,
	val playCount: Int,
	val subCount: Int,
	val shareCount: Int,
	val commentCount: Int,
	val simiMvs: List<MvVO>
)
