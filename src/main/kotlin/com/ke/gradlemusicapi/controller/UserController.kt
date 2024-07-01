package com.ke.gradlemusicapi.controller

import com.ke.gradlemusicapi.api.HttpService
import com.ke.gradlemusicapi.cookie
import com.ke.gradlemusicapi.entity.response.Playlist
import com.ke.gradlemusicapi.entity.response.UserDetailResponse
import com.ke.gradlemusicapi.entity.vo.BaseListVO
import com.ke.gradlemusicapi.entity.vo.BaseVO
import com.ke.gradlemusicapi.entity.vo.UserDetailVO
import com.ke.gradlemusicapi.util.CityUtil
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

@Tag(name = "用户")
@RestController
class UserController(
	private val httpService: HttpService,
	private val cityUtil: CityUtil
) {


	@Operation(summary = "获取用户信息")
	@SecurityRequirement(name = "Bearer Authentication")
	@GetMapping("/user/{id}")
	suspend fun userDetail(
		@PathVariable @Parameter(description = "用户id", required = true, example = "333569887")
		id: Long,

		authentication: Authentication
	) = withContext(Dispatchers.IO) {

		val playlists = async {
			httpService.getUserPlaylistList(id, cookie = authentication.cookie)
		}
		val userDetail = async {
			httpService.getUserDetail(id, authentication.cookie)
		}

		convert(id, playlists.await().playlist, userDetail.await())
	}


	private suspend fun convert(
		id: Long,
		playlists: List<Playlist>,
		userDetailResponse: UserDetailResponse
	): BaseVO<UserDetailVO> {
		val pair = cityUtil.convert(userDetailResponse.profile.province, userDetailResponse.profile.city)
		val age = userDetailResponse.createDays / 365

		val userDetail = UserDetailVO(
			id = id,
			listenSongs = userDetailResponse.listenSongs,
			level = userDetailResponse.level,
			nickname = userDetailResponse.profile.nickname,
			gender = userDetailResponse.profile.gender,
			birthday = userDetailResponse.profile.birthday,
			avatarUrl = userDetailResponse.profile.avatarUrl,
			province = userDetailResponse.profile.province,
			city = userDetailResponse.profile.city,
			backgroundUrl = userDetailResponse.profile.backgroundUrl,
			signature = userDetailResponse.profile.signature,
			followeds = userDetailResponse.profile.followeds,
			follows = userDetailResponse.profile.follows,
			createTime = userDetailResponse.createTime,
			createDays = userDetailResponse.createDays,
			playlistBeSubscribedCount = userDetailResponse.profile.playlistBeSubscribedCount,
			inBlacklist = userDetailResponse.profile.inBlacklist,
			blacklist = userDetailResponse.profile.blacklist,
			userPlaylists = playlists.filter {
				it.creator.userId == id
			},
			followedPlaylists = playlists.filter {
				it.creator.userId != id

			},
			provinceName = pair.first,
			cityName = pair.second,
			eventCount = userDetailResponse.profile.eventCount,
			age = (if (age == 0) 1 else age).toString() + "年"
		)

		return BaseVO.success(userDetail)
	}


	@Operation(summary = "获取用户粉丝")
	@SecurityRequirement(name = "Bearer Authentication")
	@GetMapping("/user/{id}/followeds")
	suspend fun userFolloweds(
		@PathVariable @Parameter(description = "用户id", required = true, example = "333569887")
		id: Long,
		@Parameter(description = "每页数量", required = true, example = "20")
		pageSize: Int,
		@Parameter(description = "页码", required = true, example = "1")
		index: Int,
		authentication: Authentication
	): BaseListVO<com.ke.gradlemusicapi.entity.response.User> {
		val cookie = authentication.cookie
		val offset = (index - 1) * pageSize
		val response = httpService.userFolloweds(id, limit = pageSize, offset, cookie = cookie)

		return BaseListVO(
			code = 200,
			success = true,
			message = "ok",
			data = response.followeds,
			hasMore = response.more
		)

	}

	@Operation(summary = "获取用户关注的人")
	@SecurityRequirement(name = "Bearer Authentication")
	@GetMapping("/user/{id}/follows")
	suspend fun userFollows(
		@PathVariable @Parameter(description = "用户id", required = true, example = "333569887")
		id: Long,
		@Parameter(description = "每页数量", required = true, example = "20")
		pageSize: Int,
		@Parameter(description = "页码", required = true, example = "1")
		index: Int,
		authentication: Authentication
	): BaseListVO<com.ke.gradlemusicapi.entity.response.User> {
		val cookie = authentication.cookie
		val offset = (index - 1) * pageSize

		val response = httpService.getUserFollows(id, limit = pageSize, offset = offset, cookie = cookie)

		return BaseListVO(
			code = 200,
			success = true,
			message = "ok",
			data = response.follow,
			hasMore = response.more
		)
	}
}