package com.ke.gradlemusicapi.entity.vo

import com.ke.gradlemusicapi.entity.response.UserAccountResponse
import com.ke.gradlemusicapi.entity.response.UserCurrentStatusResponse
import com.ke.gradlemusicapi.entity.response.UserDetailResponse
import com.ke.gradlemusicapi.entity.response.UserLevelResponse
import com.ke.gradlemusicapi.entity.response.UserSupportStatus

data class MineVO(
    val userDetail: UserDetailResponse,
    val userLevel: UserLevelResponse,
    val userAccount: UserAccountResponse,
    val supportStatusList: List<UserSupportStatus>,
    val currentStatus: UserCurrentStatusResponse
)
