package com.ke.gradlemusicapi.entity.vo

import com.ke.gradlemusicapi.entity.response.Playlist

data class UserDetailVO(
	val id: Long,
	/**
	 * 累计听歌
	 */
	val listenSongs: Int,
	val level: Int,
	val nickname: String,
	val gender: Int,
	val birthday: Long,
	val avatarUrl: String,
	val province: Int,
	val provinceName: String,
	val cityName: String,
	val city: Int,
	val backgroundUrl: String,
	val signature: String?,
	/**
	 * 粉丝
	 */
	val followeds: Int,
	/**
	 * 关注的人
	 */
	val follows: Int,
	val createTime: Long,
	val createDays: Int,

	/**
	 * 创建的歌单被收藏的次数
	 */
	val playlistBeSubscribedCount: Int,

	/**
	 * 是否处于黑名单中
	 */
	val inBlacklist: Boolean,
	val blacklist: Boolean,

	/**
	 * 用户创建的歌单
	 */
	val userPlaylists: List<Playlist>,

	/**
	 * 用户收藏的歌单
	 */
	val followedPlaylists: List<Playlist>,
	val eventCount: Int,
	/**
	 * 村龄
	 */
	val age: String
)
