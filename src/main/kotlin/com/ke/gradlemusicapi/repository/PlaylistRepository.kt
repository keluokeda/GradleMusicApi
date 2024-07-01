package com.ke.gradlemusicapi.repository

import com.ke.gradlemusicapi.entity.document.Playlist
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PlaylistRepository : CoroutineCrudRepository<Playlist, Long>