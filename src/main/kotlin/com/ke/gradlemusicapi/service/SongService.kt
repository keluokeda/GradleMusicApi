package com.ke.gradlemusicapi.service

import com.ke.gradlemusicapi.entity.response.Song
import com.ke.gradlemusicapi.repository.AlbumRepository
import com.ke.gradlemusicapi.repository.ArtistRepository
import com.ke.gradlemusicapi.repository.SongRepository
import com.ke.gradlemusicapi.repository.saveAll
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.toList
import org.springframework.stereotype.Service

@Service
class SongService(
	private val songRepository: SongRepository,
	private val albumRepository: AlbumRepository,
	private val artistRepository: ArtistRepository
) {

	suspend fun saveSongs(songs: List<Song>) {
//		songRepository.saveAll(songs.map {
//			com.ke.gradlemusicapi.entity.document.Song(it.id, it.name, it.mv, it.album, it.artists)
//		}).collect()

		songRepository.saveAll(songs)

	}

	suspend fun getSongs(): List<com.ke.gradlemusicapi.entity.document.Song> {
		return songRepository.findAll().toList()
	}
}