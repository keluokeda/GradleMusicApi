package com.ke.gradlemusicapi.entity.vo

data class BaseListVO<T>(
	val code: Int = 200,
	val success: Boolean = true,
	val message: String = "success",
	val data: List<T>,
	val hasMore: Boolean = false,
	val cursor: Long = 0
)
