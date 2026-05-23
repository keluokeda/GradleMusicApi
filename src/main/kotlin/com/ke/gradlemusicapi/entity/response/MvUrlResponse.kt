package com.ke.gradlemusicapi.entity.response

import kotlinx.serialization.Serializable

@Serializable
data class MvUrlResponse(
	val data: MvUrlData
)

@Serializable
data class MvUrlData(
	val url: String
)
