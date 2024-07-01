package com.ke.gradlemusicapi.controller

import com.ke.gradlemusicapi.api.HttpService
import com.ke.gradlemusicapi.cookie
import com.ke.gradlemusicapi.entity.vo.BaseVO
import com.ke.gradlemusicapi.entity.vo.SongDetailVO
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@Tag(name = "歌曲")
@RestController
class SongController(private val httpService: HttpService) {


	@Operation(summary = "获取歌曲详情")
	@SecurityRequirement(name = "Bearer Authentication")
	@GetMapping("/song/{id}")
	suspend fun songDetail(
		@Parameter(description = "歌曲id", required = true, example = "25920721")

		@PathVariable id: Long,
		authentication: Authentication
	): BaseVO<SongDetailVO> {

		val cookie = authentication.cookie

		val url = httpService.getSongUrl(id, cookie = cookie).data.first().url
		val song = httpService.getSongDetail(id, cookie).songs.first()
		return BaseVO.success(SongDetailVO(song, url))

	}
}