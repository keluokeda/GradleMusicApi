package com.ke.gradlemusicapi.entity.vo

import com.ke.gradlemusicapi.entity.response.Artist
import com.ke.gradlemusicapi.entity.response.NewSongItem
import com.ke.gradlemusicapi.entity.response.RecommendPlaylist
import com.ke.gradlemusicapi.entity.response.RecommendVideoItem
import com.ke.gradlemusicapi.entity.response.Song
import com.ke.gradlemusicapi.entity.response.TopArtistsResponse
import com.ke.gradlemusicapi.entity.response.ToplistItem

data class RecommendVO(
    val videos: List<RecommendVideoItem>,
    val playlists: List<RecommendPlaylist>,
    val songs: List<Song>,
    val newSongs: List<NewSongItem>,
    val toplistItems: List<ToplistItem>,
    val topArtists: List<Artist>
)