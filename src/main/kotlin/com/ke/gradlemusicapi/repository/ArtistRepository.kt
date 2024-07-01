package com.ke.gradlemusicapi.repository

import com.ke.gradlemusicapi.entity.document.Artist
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ArtistRepository : CoroutineCrudRepository<Artist, Long>