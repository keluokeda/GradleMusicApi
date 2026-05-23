package com.ke.gradlemusicapi.entity.response

import kotlinx.serialization.Serializable

@Serializable
data class SimiMvResponse(
	val mvs: List<Mv>
)
