package com.ke.gradlemusicapi.service

import com.ke.gradlemusicapi.api.HttpService
import org.springframework.stereotype.Service

@Service
class AlbumService(private val httpService: HttpService) {


	/**
	 * 获取专辑详情
	 */
	suspend fun getAlbumDetail(id: Long, cookie: String): Any {
		val albumResponse = httpService.getAlbumDetail(id, cookie)
		val dynamic = httpService.getAlbumDynamic(id, cookie)

		return albumResponse to dynamic
	}
}