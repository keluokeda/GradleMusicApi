package com.ke.gradlemusicapi.entity.response

import com.fasterxml.jackson.annotation.JsonIgnore
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
data class NotificationNoticesResponse(
    val notices: List<NotificationNoticeResponse> = emptyList(),
    val more: Boolean = false,
    val lastTime: Long? = null
)

@Serializable
data class NotificationNoticeResponse(
    val id: Long,
    val userId: Long,
    val time: Long,
    @JsonIgnore
    val notice: String,
    val type: Int
) {

    val noticeJson: Notice
        get() = json.decodeFromString<Notice>(notice)

    @Serializable
    data class Notice(
        @JsonIgnore
        val generalNotice: GeneralNotice? = null,
        /**
         * 收藏歌单
         */
        @JsonIgnore
        val playlist: Playlist? = null,
        /**
         * 点赞评论
         */
        @JsonIgnore
        val comment: Comment? = null,

        /**
         * 发起人
         */
        val user: User
    ) {
        val subTitle: String
            get() {
                if (generalNotice != null) {
                    return generalNotice.actionDesc
                } else if (playlist != null) {
                    return "收藏了你的歌单"
                } else if (comment != null) {
                    return "赞了你的评论"
                }

                return ""
            }
    }

    @Serializable
    data class GeneralNotice(
        val actionDesc: String,
    )

    @Serializable
    data class Playlist(
        val name: String,
        val id: Long
    )

    @Serializable
    data class Comment(
        val user: User,
        val content: String
    )
}

private val json = Json {
    ignoreUnknownKeys = true
    coerceInputValues = true
    isLenient = true

}