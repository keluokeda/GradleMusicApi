package com.ke.gradlemusicapi.entity.vo

import com.ke.gradlemusicapi.entity.UserRole

data class LoginVO(
	val token: String,
	val id: String,
	val roles: List<UserRole>
)
