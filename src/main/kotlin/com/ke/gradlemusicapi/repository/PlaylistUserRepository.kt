package com.ke.gradlemusicapi.repository

import com.ke.gradlemusicapi.entity.document.PlaylistUser
import kotlinx.coroutines.flow.Flow
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PlaylistUserRepository : CoroutineCrudRepository<PlaylistUser, String> {
	suspend fun deleteAllByPlaylistIdAndType(playlistId: Long, type: Int)

	suspend fun findAllByPlaylistIdAndType(playlistId: Long,type: Int): Flow<PlaylistUser>
}