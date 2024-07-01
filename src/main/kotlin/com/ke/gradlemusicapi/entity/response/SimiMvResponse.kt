package com.ke.gradlemusicapi.entity.response

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SimiMvResponse(
	val mvs: List<Mv>
)
