package com.ke.gradlemusicapi.entity.vo


import com.ke.gradlemusicapi.entity.response.Album
import com.ke.gradlemusicapi.entity.response.Artist
import com.ke.gradlemusicapi.entity.response.ArtistDescResponse
import com.ke.gradlemusicapi.entity.response.Song

data class ArtistDetailVO(
	val artist: Artist,
	val hotSongs: List<Song>,
	val desc: ArtistDescResponse,
	val simiArtists: List<Artist>,
	val mvs: List<MvVO>,
	val hotAlbums: List<Album>,
)
