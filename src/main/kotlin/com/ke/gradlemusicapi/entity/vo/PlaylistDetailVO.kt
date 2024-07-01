package com.ke.gradlemusicapi.entity.vo

import com.ke.gradlemusicapi.entity.response.Playlist
import com.ke.gradlemusicapi.entity.response.PlaylistDynamicResponse
import com.ke.gradlemusicapi.entity.response.Song

data class PlaylistDetailVO(
	val playlist: Playlist,
	val songs: List<Song>,
	val dynamic: PlaylistDynamicResponse,
	val canBook: Boolean
)
