package com.ke.gradlemusicapi.controller

import com.ke.gradlemusicapi.api.HttpService
import com.ke.gradlemusicapi.cookie
import com.ke.gradlemusicapi.entity.vo.AlbumDetailVO
import com.ke.gradlemusicapi.entity.vo.BaseVO
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@Tag(name = "专辑")
@RestController
class AlbumController(private val httpService: HttpService) {

	@Operation(summary = "获取专辑信息")
	@SecurityRequirement(name = "Bearer Authentication")
	@GetMapping("/album/{id}")
	suspend fun albumDetail(
		@PathVariable @Parameter(description = "专辑id", required = true, example = "123896397")
		id: Long,
		authentication: Authentication
	): BaseVO<AlbumDetailVO> {
		val dynamic = httpService.getAlbumDynamic(id, authentication.cookie)
		val detail = httpService.getAlbumDetail(id, authentication.cookie)

		detail.songs.map { it.album }
			.forEach {
				it.imageUrl = detail.album.picUrl
			}

		return BaseVO.success(
			AlbumDetailVO(
				dynamic.isSub,
				detail.songs,
				detail.album.name,
				detail.album.description,
				detail.album.id,
				detail.album.picUrl,
				detail.album.artists,
				detail.album.picUrl
			)
		)
	}
}