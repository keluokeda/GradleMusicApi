package com.ke.gradlemusicapi.controller

import com.ke.gradlemusicapi.api.HttpService
import com.ke.gradlemusicapi.cookie
import com.ke.gradlemusicapi.entity.response.PrivateMessage
import com.ke.gradlemusicapi.entity.vo.BaseVO
import com.ke.gradlemusicapi.entity.vo.PrivateMessageVO
import com.squareup.moshi.JsonClass
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapter
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.util.*

@Tag(name = "私信相关")
@RestController
class MessageController(private val httpService: HttpService) {


	@Operation(summary = "获取消息列表")
	@SecurityRequirement(name = "Bearer Authentication")
	@GetMapping("/message")
	suspend fun getAllMessages(
		authentication: Authentication
	) =
		httpService.getPrivateMessageList(limit = 1000, cookie = authentication.cookie).let {
			val list = it.list.map { message ->
				PrivateMessageVO(
					message.id ?: 0L,
					message.fromUser.userId,
					message.fromUser.nickname,
					message.fromUser.avatarUrl,
					Date(message.time),
					message.content(),
					message.lastMessage
				)
			}

			BaseVO.success(list)
		}


	@Operation(summary = "和某个人的私信内容")
	@SecurityRequirement(name = "Bearer Authentication")
	@GetMapping("/message/{userId}")
	suspend fun conversions(
		@PathVariable userId: Long,
		before: Long,
		authentication: Authentication
	) = httpService.getConversions(userId, before, authentication.cookie)
}


@OptIn(ExperimentalStdlibApi::class)
private val adapter = Moshi.Builder().build().adapter<LastMessage>()

private fun PrivateMessage.content(): String {
	val lastMessage = adapter.fromJson(lastMessage) ?: return ""
	return lastMessage.msg
}

@JsonClass(generateAdapter = true)
data class LastMessage(
	val msg: String
)