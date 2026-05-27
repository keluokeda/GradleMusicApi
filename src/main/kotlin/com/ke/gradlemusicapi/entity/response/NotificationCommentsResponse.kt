package com.ke.gradlemusicapi.entity.response

import com.fasterxml.jackson.annotation.JsonIgnore
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
data class NotificationCommentsResponse(
    val code: Int,
    val total: Int,
    val more: Boolean,
    val comments: List<NotificationComment>
)


@Serializable
data class NotificationComment(
    val user: User,
    val content: String,
    val time: Long,
    @JsonIgnore
    val resourceJson: String,
    val commentId: Long,
    val beRepliedUser: User? = null,
    val beRepliedContent: String? = null
) {
    val resource: ResourceJson
        get() = json.decodeFromString(resourceJson)
}

@Serializable
data class ResourceJson(
    val resourceType: Int? = null,
    val resourceSpecialType: Int? = null,
    val id: Long,
    val userId: Long,
    val name: String,
    val imgUrl: String? = null
)

private val json = Json {
    ignoreUnknownKeys = true
    coerceInputValues = true
    isLenient = true

}
