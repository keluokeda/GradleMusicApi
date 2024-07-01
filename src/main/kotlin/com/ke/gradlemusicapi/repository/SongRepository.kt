package com.ke.gradlemusicapi.repository

import com.ke.gradlemusicapi.entity.document.Song
import kotlinx.coroutines.flow.collect
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface SongRepository : CoroutineCrudRepository<Song, Long>

suspend fun SongRepository.saveAll(list: List<com.ke.gradlemusicapi.entity.response.Song>) {
	list.map {
		Song(it.id, it.name, it.mv, it.album, it.artists)
	}.apply {
		saveAll(this).collect()
	}
}