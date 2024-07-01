package com.ke.gradlemusicapi.repository

import com.ke.gradlemusicapi.entity.document.Playlist
import com.ke.gradlemusicapi.entity.document.PlaylistSong
import kotlinx.coroutines.flow.Flow
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PlaylistSongRepository : CoroutineCrudRepository<PlaylistSong, String> {
	suspend fun deleteAllByPlaylistId(playlistId: Long)

	fun findAllByPlaylistId(playlistId: Long): Flow<PlaylistSong>
}