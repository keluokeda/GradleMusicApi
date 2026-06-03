package com.ke.gradlemusicapi.entity.response

import kotlinx.serialization.Serializable

@Serializable
data class HotTopicsResponse(
    val hot: List<HotTopic>,
) {

    @Serializable
    data class HotTopic(
        val actId: Long,
        val title: String,
        val text: List<String>,
        val participateCount: Int,
        val iconUrl: String?,
        val readCnt: Long?,
        val topicDisplayType: Int?,
        val bizId: Long?,
        val bizType: Int?,
        val memberCount: Int?,
        val onlineNum: Int?,
        val sharePicUrl: String,
        val reason: String,
        val isDefaultImg: Boolean,
        val alg: String,
    )
}
