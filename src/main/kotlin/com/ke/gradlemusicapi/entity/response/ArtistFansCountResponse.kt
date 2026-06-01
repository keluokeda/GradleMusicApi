package com.ke.gradlemusicapi.entity.response

import kotlinx.serialization.Serializable

@Serializable
data class ArtistFansCountResponse(
    val isFollow: Boolean,
    val fansCnt: Long,
    val followCnt: Long,
    val followDay: String,
    val followDayCnt: Long,
    val follow: Boolean,
)
