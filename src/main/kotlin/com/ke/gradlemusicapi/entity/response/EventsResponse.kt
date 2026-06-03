package com.ke.gradlemusicapi.entity.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

@Serializable
data class EventsResponse(
    val more: Boolean,
    val event: List<Event>,
    val lasttime: Long,
) {

    @Serializable
    data class Event(
        val id: Long,
        val user: User,
        val type: Int,
        val json: String,
        val expireTime: Long,
//        val rcmdInfo: JsonElement?,
        val pics: List<EventPic>,
        val eventTime: Long,
//        val topicInfo: JsonElement?,
//        val showTime: Long,
        val actName: String? = null,
//        val pendantData: PendantData?,
//        val adInfo: AdInfo?,
//        val extJsonInfo: ExtJsonInfo,
        val tmplId: Int,
//        val pointTopicInfo: PointTopicInfo?,
//        val ipLocation: IpLocation?,
//        val info: EventInfo,
        val actId: Long,
//        val extInfo: EventXInfo?,
//        val privacySettingInfo: PrivacySettingInfo?,
//        val anonymityInfo: AnonymityInfo?,
        //底部话题
        val bottomActivityInfos: List<Info> = emptyList()
    )

    @Serializable
    data class Info(val id: String, val name: String)

    @Serializable
    data class EventUser(
        val locationInfo: JsonElement?,
        val liveInfo: JsonElement?,
        val anonym: Int,
        val commonIdentity: JsonElement?,
        val avatarDetail: AvatarDetail?,
        val anchor: Boolean?,
        val userId: Long,
        val userType: Int,
        val avatarUrl: String,
        val authStatus: Int,
        val followed: Boolean,
        val mutual: Boolean,
        val remarkName: String?,
        val vipType: Int,
        val nickname: String,
        val avatarImgId: Long,
        @SerialName("avatarImgId_str")
        val avatarImgIdStr: String,
        val signature: String,
        val description: String,
        val backgroundUrl: String,
        val backgroundImgId: Long,
        val djStatus: Int,
        val expertTags: List<String>?,
        val experts: Map<String, String>?,
        val vipRights: VipRights?,
        val accountStatus: Int,
        val gender: Int,
        val province: Int,
        val city: Int,
        val birthday: Long,
        val followeds: Int,
        val follows: Int,
        val eventCount: Int,
        val allSubscribedCount: Int,
        val playlistCount: Int,
        val playlistBeSubscribedCount: Int,
    )

    @Serializable
    data class AvatarDetail(
        val userType: Int,
        val identifyTag: String?,
        val identifyText: String?,
    )

    @Serializable
    data class VipRights(
        val associator: VipItem?,
        val musicPackage: VipItem?,
        val redplus: VipItem?,
        val redVipAnnualCount: Int?,
        val redVipLevel: Int?,
        val extInfo: VipExtInfo?,
    )

    @Serializable
    data class VipItem(
        val vipCode: Int,
        val rights: Boolean,
        val iconUrl: String?,
        val dynamicIconUrl: String?,
        val vipLevel: Int?,
        val expireTime: Long?,
    )

    @Serializable
    data class VipExtInfo(
        val redVipFreeType: Int?,
    )

    @Serializable
    data class EventInfo(
        val commentThread: CommentThread,
        val liked: Boolean,
        val likedCount: Int,
        val shareCount: Int,
        val replyCount: Int,
        val comments: Map<String, JsonElement>?,
        val topComments: List<JsonElement>?,
        val resourceType: Int,
        val resourceId: Long,
    )

    @Serializable
    data class CommentThread(
        val id: String,
        val resourceInfo: ResourceInfo?,
        val commentCount: Int,
        val likedCount: Int,
        val shareCount: Int,
        val hotTopicCnt: Int?,
        val latestLikedUsers: List<LikedUser>?,
        val liked: Boolean,
    )

    @Serializable
    data class ResourceInfo(
        val id: Long,
        val userId: Long,
        val name: String,
        val imageUrl: String?,
        val creator: JsonElement?,
        val encodedId: String?,
        val subTitle: String?,
        val webUrl: String?,
    )

    @Serializable
    data class LikedUser(
        val userId: Long,
        val avatarUrl: String,
        val nickname: String,
        val userType: Int,
        val avatarDetail: AvatarDetail?,
        val vipRights: VipRights?,
        val vipType: Int,
    )

    @Serializable
    data class EventPic(
        val originUrl: String,
        val squareUrl: String,
        val pcSquareUrl: String,
        val mobileSquareUrl: String? = null,
        val width: Int,
        val height: Int,
        val fileSize: Long? = null,
    )

    @Serializable
    data class ExtJsonInfo(
        val actId: Long,
        val actName: String,
        val actType: Int,
        val auditStatus: Int,
        val contentId: String,
        val hasAudio: Boolean,
        val hasVideo: Boolean,
        val isHot: Boolean,
        val isShow: Boolean,
        val momentScore: MomentScore?,
        val pictureScore: PictureScore?,
        val riskControlComplainDTO: RiskControlComplainDTO?,
        val userClientInfoDTO: UserClientInfoDTO?,
        val actInfo: ActivityInfo?,
        val logInfo: LogInfo?,
        val containAiContent: Boolean?,
        val relationTopic: Boolean?,
    )

    @Serializable
    data class MomentScore(
        val commentScore: Double?,
        val likeScore: Double?,
        val shareScore: Double?,
        val playScore: Double?,
        val score: Double?,
    )

    @Serializable
    data class PictureScore(
        val qualityScore: Double?,
        val aestheticsScore: Double?,
        val score: Double?,
    )

    @Serializable
    data class RiskControlComplainDTO(
        val enable: Boolean,
        val complainType: Int?,
        val complainText: String?,
    )

    @Serializable
    data class UserClientInfoDTO(
        val clientIp: String?,
        val platform: String?,
        val version: String?,
    )

    @Serializable
    data class ActivityInfo(
        val actId: Long,
        val actName: String,
        val actType: Int,
        val actUrl: String?,
        val startTime: Long?,
        val endTime: Long?,
        val logo: VipLogo?,
    )

    @Serializable
    data class VipLogo(
        val logoDto: LogoDto?,
        val webLogoDto: LogoDto?,
    )

    @Serializable
    data class LogoDto(
        val logoUrl: String?,
        val logoPicId: Long?,
    )

    @Serializable
    data class LogInfo(
        val acted: Boolean?,
        @SerialName("knowledge_id")
        val knowledgeId: String?,
        @SerialName("new_topic")
        val newTopic: Boolean?,
    )

//    @Serializable
//    data class PointTopicInfo(
//        val actId: Long,
//        val actName: String,
//        val actType: Int,
//    )

    @Serializable
    data class IpLocation(
        val ip: String?,
        val location: String?,
        val userId: Long?,
    )

//    @Serializable
//    data class AnonymityInfo(
//        val showAnonymous: Boolean,
//        val anonymitySimpleInfo: AnonymityInfoSimple?,
//    )

    @Serializable
    data class AnonymityInfoSimple(
        val anonymousAvatarUrl: String?,
        val anonymousNickname: String?,
    )

    @Serializable
    data class PendantData(
        val id: Long,
        val imageUrl: String,
    )

    @Serializable
    data class AdInfo(
        val adId: String?,
        val adType: Int?,
    )

//    @Serializable
//    data class PrivacySettingInfo(
//        val showPrivacy: Boolean,
//        val privacyType: Int?,
//    )

    @Serializable
    data class EventXInfo(
        val topicInfo: JsonElement?,
        val extParams: Map<String, String>?,
    )
}
