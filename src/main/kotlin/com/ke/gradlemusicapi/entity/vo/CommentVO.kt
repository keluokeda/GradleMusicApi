package com.ke.gradlemusicapi.entity.vo

import com.ke.gradlemusicapi.entity.response.Comment
import com.ke.gradlemusicapi.entity.response.IpLocation
import com.ke.gradlemusicapi.entity.response.User

data class CommentVO(
	val commentId: Long = 0,
	val user: User,
	val content: String?,
	val timeString: String = "",
	val time: Long = 0,
	val likedCount: Int = 0,
	val ipLocation: String = "",
	val owner: Boolean = false,
	val liked: Boolean = false,
	val parentCommentId: Long = 0L,
	/**
	 * 子评论数
	 */
	val replyCount: Int = 0
) {

	companion object {
		fun fromComment(comment: Comment): CommentVO {
			return CommentVO(
				commentId = comment.commentId,
				user = comment.user,
				content = comment.content,
				timeString = comment.timeString,
				time = comment.time,
				likedCount = comment.likedCount,
				ipLocation = comment.ipLocation.location,
				owner = comment.owner,
				liked = comment.liked,
				parentCommentId = comment.parentCommentId,
				replyCount = comment.replyCount
			)
		}
	}
}
