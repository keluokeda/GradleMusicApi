package com.ke.gradlemusicapi.controller

import com.ke.gradlemusicapi.api.HttpService
import com.ke.gradlemusicapi.cookie
import com.ke.gradlemusicapi.entity.vo.BaseListVO
import com.ke.gradlemusicapi.entity.vo.EventVO
import com.ke.gradlemusicapi.entity.vo.convert
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
@Tag(name = "动态")
@RestController
class EventController(private val httpService: HttpService) {

    @Operation(summary = "全部动态")
    @SecurityRequirement(name = "Bearer Authentication")
    @GetMapping("/events")
    suspend fun events(
        pageSize: Int,
        lastTime: Long,
        authentication: Authentication
    ): BaseListVO<EventVO> {
        val response = httpService.events(
            pageSize = pageSize, lastTime = lastTime, cookie = authentication.cookie
        )

        return BaseListVO(
            data = response.event.map { it.convert() },
            hasMore = response.more,
            cursor = response.lasttime
        )
    }
}