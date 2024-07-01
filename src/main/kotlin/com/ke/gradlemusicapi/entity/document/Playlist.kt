package com.ke.gradlemusicapi.entity.document

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document
data class Playlist(
	@Id
	val id: Long,
	/**
	 * 创建者
	 */
	val creator: User,
	/**
	 * 封面图片地址
	 */
	@Field("cover")
	val coverImgUrl: String,
	/**
	 * 名字
	 */
	val name: String,
	/**
	 * 标签
	 */
	val tags: List<String>,
	/**
	 * 描述
	 */
	val description: String?,
	/**
	 * 歌曲数量
	 */
	@Field("track_count")
	val trackCount: Long,
	/**
	 * 总播放次数
	 */
	@Field("play_count")
	val playCount: Long,


	/**
	 * 更新时间
	 */
	@Field("update_time")
	val updateTime: Long,

	/**
	 * 分享次数
	 */
	@Field("share_count")
	val shareCount: Long,

	/**
	 * 订阅数量
	 */
	@Field("booked_count")
	val bookedCount: Long,


	/**
	 * 评论数量
	 */
	@Field("comment_count")
	val commentCount: Long
)