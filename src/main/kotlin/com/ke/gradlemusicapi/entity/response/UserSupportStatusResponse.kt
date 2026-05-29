package com.ke.gradlemusicapi.entity.response

import kotlinx.serialization.Serializable

@Serializable
data class UserSupportStatusResponse(
    val code: Int,
    val data: List<UserSupportStatus>
)

/**
 * {
 *       "type": "LISTENING",
 *       "iconUrl": "https://p5.music.126.net/obj/wo3DlcOGw6DClTvDisK1/11399985289/69a6/da34/93a3/ed7abfe26cd6481d43d99fde73091cef.png",
 *       "content": "最近在听歌",
 *       "actionUrl": null,
 *       "vistorUrl": null,
 *       "canEdit": false,
 *       "desc": null
 *     }
 */
@Serializable
data class UserSupportStatus(
    val type: String,
    val iconUrl: String,
    val content: String
)