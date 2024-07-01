package com.ke.gradlemusicapi.controller

import com.ke.gradlemusicapi.api.HttpService
import com.ke.gradlemusicapi.cookie
import com.ke.gradlemusicapi.entity.response.Mv
import com.ke.gradlemusicapi.entity.response.MvDetailData
import com.ke.gradlemusicapi.entity.vo.BaseVO
import com.ke.gradlemusicapi.entity.vo.MvDetailVO
import com.ke.gradlemusicapi.entity.vo.MvVO
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import io.swagger.v3.oas.annotations.tags.Tag
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@Tag(name = "mv相关")
@RestController
class MvController(private val httpService: HttpService) {

	@Operation(summary = "获取mv信息")
	@SecurityRequirement(name = "Bearer Authentication")
	@GetMapping("/mv/{id}")
	suspend fun mvDetail(
		@Parameter(
			name = "id",
			required = true,
			example = "14530277"
		)
		@PathVariable id: Long,
		authentication: Authentication,
	) = withContext(Dispatchers.IO) {
		val simiMvs = async {
			httpService.simiMvs(id, authentication.cookie).mvs
		}

		val detail = async {
			httpService.mvDetail(id, authentication.cookie)

		}
		val url = async {
			httpService.mvUrl(id, authentication.cookie).data.url
		}
		BaseVO.success(convert(simiMvs.await(), detail.await().data, url.await()))
	}

	private fun convert(mvs: List<Mv>, detail: MvDetailData, url: String): MvDetailVO {
		return MvDetailVO(
			id = detail.id,
			name = detail.name,
			artists = detail.artists,
			url = url,
			cover = detail.cover,
			playCount = detail.playCount,
			subCount = detail.subCount,
			shareCount = detail.shareCount,
			commentCount = detail.commentCount,
			simiMvs = mvs.map {
				MvVO(it.id, it.name, it.cover)
			}
		)
	}
}