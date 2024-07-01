package com.ke.gradlemusicapi.entity.response

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserDetailResponse(
	val level: Int,
	val listenSongs: Int,
	val profile: UserDetailProfile,
	val createTime: Long,
	val createDays: Int
)

@JsonClass(generateAdapter = true)
data class UserDetailProfile(
	val avatarUrl: String,
	val nickname: String,
	val userId: Long,
	val signature: String?,
	val backgroundUrl: String,
	val province: Int,
	val city: Int,
	val gender: Int,
	val birthday: Long,
	val followeds: Int,
	val follows: Int,
	val blacklist: Boolean,
	val inBlacklist: Boolean,
	val playlistBeSubscribedCount: Int,
	val playlistCount: Int,
	val eventCount: Int,
)
