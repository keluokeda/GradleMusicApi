package com.ke.gradlemusicapi.entity.response

import kotlinx.serialization.Serializable

@Serializable
data class ArtistFansResponse(
    val userProfile: UserProfile
) {
    @Serializable
    data class UserProfile(
        val nickname: String,
        val avatarUrl: String,
        val signature: String? = null,
        val followed: Boolean,
        val userId: Long
    )
}