package com.ke.gradlemusicapi.controller

import com.ke.gradlemusicapi.service.PlaylistService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController(private val playlistService: PlaylistService) {

	@GetMapping("/test/playlist/{playlistId}")
	suspend fun playlistDetail(@PathVariable playlistId: Long) = playlistService.getPlaylistDetail(playlistId)

	@GetMapping("/test/playlist/{playlistId}/subscribers")
	suspend fun getPlaylistSubscribers(@PathVariable playlistId: Long) =
		playlistService.getPlaylistSubscribers(playlistId)
}