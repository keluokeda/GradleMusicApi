package com.ke.gradlemusicapi.repository

import com.ke.gradlemusicapi.entity.document.Album
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface AlbumRepository : CoroutineCrudRepository<Album, Long>