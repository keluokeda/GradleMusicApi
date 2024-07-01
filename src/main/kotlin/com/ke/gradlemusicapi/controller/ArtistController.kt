package com.ke.gradlemusicapi.controller


import com.ke.gradlemusicapi.api.HttpService
import com.ke.gradlemusicapi.cookie
import com.ke.gradlemusicapi.entity.vo.ArtistDetailVO
import com.ke.gradlemusicapi.entity.vo.BaseVO
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

@Tag(name = "歌手")
@RestController
class ArtistController(private val httpService: HttpService) {

	@Operation(summary = "获取歌手详情")
	@SecurityRequirement(name = "Bearer Authentication")
	@GetMapping("/artist/{id}")
	suspend fun getArtistDetail(
		@Parameter(description = "歌手id", required = true, example = "10577")
		@PathVariable id: Long, authentication: Authentication
	) = withContext(Dispatchers.IO) {
		val cookie = authentication.cookie
		val artist = async {
			val response = httpService.getArtists(id, cookie)
			response.artist to response.hotSongs
		}.await()


		val artistDesc = async {
			httpService.getArtistDesc(id, cookie)
		}
		val simiArtists = async {
			httpService.getSimiArtist(id, authentication.cookie)
		}
		val mvs = async {
			httpService.getArtistMv(id, 1000, cookie)
		}
		val albums = async {
			httpService.getArtistAlbums(id, 1000, cookie)
		}

		return@withContext BaseVO.success(
			ArtistDetailVO(
				artist.first,
				artist.second,
				artistDesc.await(),
				simiArtists.await().artists,
				mvs.await().mvs.map {
					MvVO(it.id, it.name, it.image)
				},
				albums.await().hotAlbums
			)
		)
	}
}