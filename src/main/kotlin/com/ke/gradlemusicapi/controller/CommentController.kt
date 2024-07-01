package com.ke.gradlemusicapi.controller

import com.ke.gradlemusicapi.api.HttpService
import com.ke.gradlemusicapi.cookie
import com.ke.gradlemusicapi.entity.vo.BaseListVO
import com.ke.gradlemusicapi.entity.vo.CommentVO
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@Tag(name = "评论")
@RestController
class CommentController(private val httpService: HttpService) {




	@Operation(summary = "获取评论")
	@SecurityRequirement(name = "Bearer Authentication")
	@GetMapping("/comment")
	suspend fun getComments(
		@Parameter(description = "资源类型", required = true, example = "0")
		type: Int,
		@Parameter(description = "资源id", required = true, example = "25920721")
		id: Long,
		@Parameter(description = "每页数量", required = true, example = "20")
		pageSize: Int,
		@Parameter(description = "页码", required = true, example = "1")
		index: Int,
		@Parameter(description = "游标", required = true, example = "0")
		cursor: Long,
		authentication: Authentication
	): BaseListVO<CommentVO> {


		val response = httpService.getComments(id, type, 2, pageSize, index, null, authentication.cookie)
		val list = response.data.comments?.map { CommentVO.fromComment(it) } ?: emptyList()

		val target = list.distinctBy {
			it.commentId
		}
		val size = target.size

		print(size)

		return BaseListVO(
			data = list,
			hasMore = response.data.hasMore,
			cursor = response.data.nextPageCursor
		)
	}

	@Operation(summary = "获取子评论")
	@SecurityRequirement(name = "Bearer Authentication")
	@GetMapping("/comment/{commentId}/child")
	suspend fun getChildComments(
		@Parameter(description = "资源类型", required = true, example = "0")
		type: Int,
		@Parameter(description = "资源id", required = true, example = "25920721")
		id: Long,
		@Parameter(description = "每页数量", required = true, example = "20")
		pageSize: Int,
		@Parameter(description = "分页参数,取上一页最后一项的 time 获取下一页数据", required = true, example = "0")
		time: Long,
		@Parameter(description = "评论id", required = true, example = "315109812")
		@PathVariable commentId: Long,
		authentication: Authentication
	): BaseListVO<CommentVO> {


		val response =
			httpService.getChildComments(id, type, commentId, pageSize, time, authentication.cookie)
//		httpService.getComments(id, type, 2, pageSize, index, null, authentication.cookie)


		val list = response.data.comments?.map { CommentVO.fromComment(it) } ?: emptyList()

		return BaseListVO(
			data = list,
			hasMore = response.data.hasMore,
			cursor = list.lastOrNull()?.time ?: 0
		)
	}
}