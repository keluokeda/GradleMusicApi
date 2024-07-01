package com.ke.gradlemusicapi.entity.response

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MvUrlResponse(
	val data: MvUrlData
)

@JsonClass(generateAdapter = true)
data class MvUrlData(
	val url: String
)
