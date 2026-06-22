package com.ke.gradlemusicapi.entity.response

import kotlinx.serialization.Serializable

@Serializable
data class ArtistDetailResponse(
    val videoCount: Int,
    val identify: ArtistIdentify? = null,
    val artist: ArtistDetail,
    val blacklist: Boolean,
    val preferShow: Int,
    val showPriMsg: Boolean,
    val secondaryExpertIdentiy: List<ExpertIdentity>,
) {

    @Serializable
    data class ArtistIdentify(
//        val imageUrl: String?,
        val imageDesc: String,
        val actionUrl: String,
    )

    @Serializable
    data class ArtistDetail(
        val id: Long,
        val cover: String,
        val avatar: String,
        val name: String,
        val transNames: List<String>,
        val alias: List<String>,
        val identities: List<String>,
//        val identifyTag: String?,
        val briefDesc: String,
        val rank: ArtistRank?,
        val albumSize: Int,
        val musicSize: Int,
        val mvSize: Int,
    )

    @Serializable
    data class ArtistRank(
        val rank: Int,
        val type: Int,
    )

    @Serializable
    data class ExpertIdentity(
        val expertIdentiyId: Long,
        val expertIdentiyName: String,
        val expertIdentiyCount: Int,
    )
}