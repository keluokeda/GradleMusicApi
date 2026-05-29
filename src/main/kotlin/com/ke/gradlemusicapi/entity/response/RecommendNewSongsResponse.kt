package com.ke.gradlemusicapi.entity.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RecommendNewSongsResponse(
    val result: List<NewSongItem>,
    val code: Int,
    val category: Int
)

@Serializable
data class NewSongItem(
    val song: NewSong,
    val picUrl: String,
    val canDislike: Boolean,
    val name: String,
    val id: Long,
    val type: Int,
    val alg: String
)

@Serializable
data class NewSong(
    val id: Long,
    val name: String,
    val duration: Int,
    val fee: Int,
    val mvid: Long,
    val no: Int,
    val disc: String,
    val copyright: Int,
    val copyrightId: Long,
    val commentThreadId: String,
    val publishTime: Long,
    val popularity: Int,
    val score: Int,
    val originCoverType: Int,
    val alias: List<String>,
    val artists: List<Artist>,
    val album: NewSongAlbum,
    val privilege: NewSongPrivilege,
    val lMusic: MusicQuality? = null,
    val mMusic: MusicQuality? = null,
    val hMusic: MusicQuality? = null,
    val sqMusic: MusicQuality? = null,
    val hrMusic: MusicQuality? = null,
    val bMusic: MusicQuality? = null,
    val originSongSimpleData: OriginSongSimpleData? = null
)

@Serializable
data class NewSongAlbum(
    val id: Long,
    val name: String,
    val picUrl: String,
    val publishTime: Long,
    val type: String,
    val subType: String,
    val company: String = "",
    val size: Int,
    val artist: Artist,
    val artists: List<Artist>
)

@Serializable
data class MusicQuality(
    val id: Long,
    val extension: String,
    val bitrate: Int,
    val size: Long,
    val playTime: Int,
    val sr: Int
)

@Serializable
data class NewSongPrivilege(
    val id: Long,
    val fee: Int,
    val payed: Int,
    val st: Int,
    val pl: Int,
    val dl: Int,
    val sp: Int,
    val cp: Int,
    val subp: Int,
    val cs: Boolean,
    val maxbr: Int,
    val fl: Int,
    val toast: Boolean,
    val flag: Long,
    val preSell: Boolean,
    val plLevel: String,
    val dlLevel: String,
    val flLevel: String,
    val maxBrLevel: String,
    val playMaxbr: Int,
    val playMaxBrLevel: String,
    val downloadMaxbr: Int,
    val downloadMaxBrLevel: String,
    val chargeInfoList: List<ChargeInfo>,
    val freeTrialPrivilege: FreeTrialPrivilege
)

@Serializable
data class ChargeInfo(
    val rate: Int,
    val chargeType: Int
)

@Serializable
data class FreeTrialPrivilege(
    val userConsumable: Boolean,
    val resConsumable: Boolean
)

@Serializable
data class OriginSongSimpleData(
    val name: String,
    val songId: Long,
    val artists: List<OriginSongArtist>,
    val albumMeta: OriginSongAlbumMeta
)

@Serializable
data class OriginSongArtist(
    val id: Long,
    val name: String
)

@Serializable
data class OriginSongAlbumMeta(
    val id: Long,
    val name: String
)