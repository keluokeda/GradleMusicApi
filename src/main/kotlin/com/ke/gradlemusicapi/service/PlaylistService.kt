package com.ke.gradlemusicapi.service

import com.ke.gradlemusicapi.entity.document.Playlist
import com.ke.gradlemusicapi.entity.document.PlaylistSong
import com.ke.gradlemusicapi.entity.document.PlaylistUser
import com.ke.gradlemusicapi.entity.document.User
import com.ke.gradlemusicapi.entity.vo.PlaylistDetailVO
import com.ke.gradlemusicapi.repository.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.toList
import org.springframework.data.mongodb.core.aggregation.BooleanOperators
import org.springframework.stereotype.Service

@Service
class PlaylistService(
	private val playlistRepository: PlaylistRepository,
	private val songRepository: SongRepository,
	private val playlistSongRepository: PlaylistSongRepository,
	private val userRepository: UserRepository,
	private val playlistUserRepository: PlaylistUserRepository
) {

	/**
	 * 保存歌单详情
	 */
	suspend fun savePlaylistDetail(playlistDetailVO: PlaylistDetailVO, currentUserId: Long) {

		///保存歌单信息
		playlistDetailVO.playlist.apply {
			val playlist =
				Playlist(
					id,
					User(creator.userId, creator.signature ?: "", creator.nickname, creator.avatarUrl),
					coverImgUrl,
					name,
					tags,
					description,
					trackCount,
					playCount,
					shareCount = playlistDetailVO.dynamic.shareCount,
					updateTime = updateTime,
					bookedCount = playlistDetailVO.dynamic.bookedCount,
					commentCount = playlistDetailVO.dynamic.commentCount
				)
			playlistRepository.save(playlist)
		}

		//保存歌单歌曲
		songRepository.saveAll(playlistDetailVO.songs)

		//删除歌单歌曲关系
		playlistSongRepository.deleteAllByPlaylistId(playlistDetailVO.playlist.id)
		val list = playlistDetailVO.songs.mapIndexed { index, song ->

			PlaylistSong(
				playlistDetailVO.playlist.id.toString() + song.id.toString(),
				playlistDetailVO.playlist.id,
				song.id,
				index
			)
		}
		//保存歌单歌曲关系
		playlistSongRepository.saveAll(list).collect()
	}


	suspend fun getPlaylistDetail(id: Long): Map<String, Any> {
		val playlist = playlistRepository.findById(id) ?: return mapOf("code" to "404")

		val playlistSongs = playlistSongRepository.findAllByPlaylistId(id).toList()

		val songs = songRepository.findAllById(playlistSongs.map { it.songId })
			.toList()
			.map { song ->
				val index = playlistSongs.find { it.songId == song.id }!!.index

				index to song
			}.sortedBy {
				it.first
			}.map {
				it.second
			}

		return mapOf("playlist" to playlist, "songs" to songs)
	}

	/**
	 * 保存歌单收藏者
	 */
	suspend fun savePlaylistSubscribers(
		playlistId: Long,
		subscribers: List<com.ke.gradlemusicapi.entity.response.User>,
		index: Int,
		size: Int,
		deleteOld: Boolean = false
	) {


		//保存用户
		userRepository.saveAll(subscribers.map {
			User(it.userId, it.signature ?: "", it.nickname, it.avatarUrl)
		}).collect()

		if (deleteOld) {
			//删除旧的数据
			playlistUserRepository.deleteAllByPlaylistIdAndType(playlistId, 2)
		}

		//保存歌单用户关系
		playlistUserRepository.saveAll(
			subscribers.map {
				PlaylistUser(null, playlistId, it.userId, type = 2)
			}
		).collect()
	}

	/**
	 * 获取歌单的收藏者
	 */
	suspend fun getPlaylistSubscribers(playlistId: Long): List<User> {
		val playlistUserList = playlistUserRepository.findAllByPlaylistIdAndType(playlistId, 2).toList()

		return userRepository.findAllById(playlistUserList
			.map { it.userId }
		)
			.toList().map { user ->
				user to playlistUserList.indexOfFirst { it.userId == user.id }
			}.sortedBy {
				it.second
			}.map {
				it.first
			}
	}
}