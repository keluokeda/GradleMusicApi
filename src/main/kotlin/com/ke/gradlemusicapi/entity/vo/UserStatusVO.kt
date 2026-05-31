package com.ke.gradlemusicapi.entity.vo

import com.ke.gradlemusicapi.entity.response.UserSupportStatus

data class UserStatusVO(
    val current: UserSupportStatus?,
    val list: List<UserSupportStatus>
)
