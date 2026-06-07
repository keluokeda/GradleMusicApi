package com.ke.gradlemusicapi.entity.response

import kotlinx.serialization.Serializable
//{"ids":[229285],"code":200}
@Serializable
data class CheckSongLikeResponse(
    val ids: List<Long> = emptyList()
)
