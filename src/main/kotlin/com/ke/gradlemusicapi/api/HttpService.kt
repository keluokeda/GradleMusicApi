package com.ke.gradlemusicapi.api

import com.ke.gradlemusicapi.entity.response.*
import retrofit2.http.GET
import retrofit2.http.Query

interface HttpService {
	/**
	 * 检查登录状态
	 */
	@GET("login/status")
	suspend fun loginStatus(
		@Query("cookie") cookie: String? = null,
	): LoginStatusResponse

	/**
	 * 生成登录二维码key
	 */
	@GET("login/qr/key")
	suspend fun createQRKey(): LoginQRKeyResponse

	/**
	 * 创建二维码url
	 */
	@GET("login/qr/create")
	suspend fun createQRUrl(
		@Query("key") key: String,
		@Query("qrimg") qr: String? = null
	): LoginQRCreateResponse

	/**
	 * 检查是否登录成功
	 */
	@GET("login/qr/check")
	suspend fun checkLoginByKey(
		@Query("key") key: String,
	): CheckLoginResponse

	/**
	 * 获取私信消息
	 */
	@GET("msg/private")
	suspend fun getPrivateMessageList(
		@Query("limit") limit: Int = 1000,
		@Query("cookie") cookie: String? = null,

		): PrivateMessageResponse

	/**
	 * 通知-评论
	 */
	@GET("msg/comments")
	suspend fun notificationComments(
		@Query("uid") uid: Long,
		@Query("limit") limit: Int = 20,
		@Query("before") before: Long? = null,
		@Query("cookie") cookie: String? = null,
	): NotificationCommentsResponse

	/**
	 * 通知-通知
	 */
	@GET("msg/notices")
	suspend fun notificationNotice(
		@Query("lasttime") cursor: Long? = null,
		@Query("cookie") cookie: String? = null,
	): NotificationNoticesResponse

	/**
	 * 获取私信内容
	 */
	@GET("msg/private/history")
	suspend fun getConversions(
		@Query("uid") uid: Long,
		@Query("before") before: Long,
		@Query("cookie") cookie: String? = null,
	): Map<String, Any>

	/**
	 * 获取用户歌单列表
	 */
	@GET("user/playlist")
	suspend fun getUserPlaylistList(
		@Query("uid") userId: Long,
		@Query("limit") limit: Int = 1000,
		@Query("cookie") cookie: String? = null,
	): UserPlaylistResponse

	/**
	 * 获取歌单详情
	 */
	@GET("playlist/detail")
	suspend fun getPlaylistDetail(
		@Query("id") id: Long, @Query("cookie") cookie: String? = null,
	): PlaylistDetailResponse

	/**
	 * 获取歌单歌曲
	 */
	@GET("/playlist/track/all")
	suspend fun getPlaylistTracks(
		@Query("id") id: Long, @Query("cookie") cookie: String? = null,
	): PlaylistTracksResponse

	/**
	 * 获取歌单动态信息
	 */
	@GET("playlist/detail/dynamic")
	suspend fun getPlaylistDetailDynamic(
		@Query("id") id: Long, @Query("cookie") cookie: String? = null,
	): PlaylistDynamicResponse


	/**
	 * 创建歌单
	 */
	@GET("playlist/create")
	suspend fun createPlaylist(
		@Query("name") name: String, @Query("cookie") cookie: String? = null,
	): CodeResponse

	/**
	 * 删除歌单
	 */
	@GET("playlist/delete")
	suspend fun deletePlaylist(
		@Query("id") id: Long, @Query("cookie") cookie: String? = null,
	)

	/**
	 * 获取资源评论
	 * @param id 资源的id
	 * @param type 资源类型 0表示歌曲，1表示mv，2表示歌单，3表示专辑，4表示电台，5表示视频，6表示动态 7表示电台
	 * @param sortType 排序方式  1:按推荐排序, 2:按热度排序, 3:按时间排序
	 * @param cursor 当sortType为 3 时且页数不是第一页时需传入,值为上一条数据的 time
	 */
	@GET("comment/new")
	suspend fun getComments(
		@Query("id") id: Long,
		@Query("type") type: Int,
		@Query("sortType") sortType: Int,
		@Query("pageSize") pageSize: Int,
		@Query("pageNo") pageNo: Int,
		@Query("cursor") cursor: Long?,
		@Query("cookie") cookie: String? = null,

		): CommentsResponse


	/**
	 * 子评论
	 * @param id 资源的id
	 * @param type 资源类型
	 * @param parentCommentId 主评论id
	 */
	@GET("comment/floor")
	suspend fun getChildComments(
		@Query("id") id: Long,
		@Query("type") type: Int,
		@Query("parentCommentId") parentCommentId: Long,
		@Query("limit") limit: Int,
		@Query("time") time: Long,
		@Query("cookie") cookie: String? = null,
	): CommentsResponse

	/**
	 * 给评论点赞
	 */
	@GET("comment/like")
	suspend fun likeComment(
		@Query("id") id: Long,
		@Query("cid") commentId: Long,
		@Query("type") type: Int,
		@Query("t") like: Int,
		@Query("cookie") cookie: String? = null,

		): CodeResponse

	/**
	 * 发送评论
	 * @param action 1表示发送 2表示回复
	 * @param type
	 * @param id 对应资源id
	 * @param content 回复的内容
	 * @param commentId 如果是回复评论，需要传入被评论的id
	 */
	@GET("comment")
	suspend fun sendComment(
		@Query("t") action: Int,
		@Query("type") type: Int,
		@Query("id") id: Long,
		@Query("content") content: String,
		@Query("commentId") commentId: Long? = null,
		@Query("cookie") cookie: String? = null,

		): CodeResponse


	/**
	 * 删除评论
	 */
	@GET("comment?t=0")
	suspend fun deleteComment(
		@Query("type") type: Int,
		@Query("id") id: Long,
		@Query("commentId") commentId: Long,
		@Query("cookie") cookie: String? = null,

		)

	/**
	 * 获取某个用户关注的人
	 */
	@GET("user/follows")
	suspend fun getUserFollows(
		@Query("uid") userId: Long,
		@Query("limit") limit: Int = 1000,
		@Query("offset") offset: Int = 0,
		@Query("cookie") cookie: String? = null,

		): UserFollowsResponse

	/**
	 * 用户粉丝
	 */
	@GET("user/followeds")
	suspend fun userFolloweds(
		@Query("uid") userId: Long,
		@Query("limit") limit: Int = 1000,
		@Query("offset") offset: Int = 0,
		@Query("cookie") cookie: String? = null,
	): UserFollowsResponse

	/***
	 * 发送歌单给用户
	 */
	@GET("send/playlist")
	suspend fun sendPlaylistToUsers(
		@Query("user_ids") users: String,
		@Query("playlist") playlistId: Long,
		@Query("msg") content: String,
		@Query("cookie") cookie: String? = null,

		): CodeResponse

	/**
	 * 分享专辑给用户
	 */
	@GET("send/album")
	suspend fun sendAlbumToUsers(
		@Query("user_ids") users: String,
		@Query("id") albumId: Long,
		@Query("msg") content: String,
		@Query("cookie") cookie: String? = null,

		): CodeResponse

	/**
	 * 分享歌曲给用户
	 */
	@GET("send/song")
	suspend fun sendSongToUsers(
		@Query("user_ids") users: String,
		@Query("id") albumId: Long,
		@Query("msg") content: String,
		@Query("cookie") cookie: String? = null,

		): CodeResponse

	/**
	 * 歌单订阅者
	 */
	@GET("playlist/subscribers")
	suspend fun playlistSubscribers(
		@Query("id") id: Long,
		@Query("offset") offset: Int,
		@Query("limit") limit: Int,
		@Query("cookie") cookie: String? = null,

		): PlaylistSubscribersResponse

	/**
	 * 关注用户
	 * @param action 1表示关注 2表示取关
	 */
	@GET("follow")
	suspend fun followUser(
		@Query("id") id: Long,
		@Query("t") action: Int,
		@Query("cookie") cookie: String? = null,

		): CodeResponse

	/**
	 * 获取专辑信息
	 */
	@GET("album")
	suspend fun getAlbumDetail(
		@Query("id") id: Long,
		@Query("cookie") cookie: String? = null,

		): AlbumResponse


	/**
	 * 专辑动态信息
	 */
	@GET("album/detail/dynamic")
	suspend fun getAlbumDynamic(
		@Query("id") id: Long,
		@Query("cookie") cookie: String? = null,

		): AlbumDynamicResponse

	/**
	 * 添加或删除歌曲到歌单
	 */
	@GET("playlist/tracks")
	suspend fun addOrRemoveSongsToPlaylist(
		@Query("op") option: String,
		@Query("pid") playlistId: Long,
		@Query("tracks") tracks: String,
		@Query("cookie") cookie: String? = null,

		)

	/**
	 *网友精选碟
	 */
	@GET("top/playlist")
	suspend fun getTopPlaylist(
		@Query("cat") category: String? = null,
		@Query("limit") limit: Int,
		@Query("offset") offset: Int,
		@Query("cookie") cookie: String? = null,

		): PlaylistTopResponse

	/**
	 * 歌单分类
	 */
	@GET("playlist/catlist")
	suspend fun getPlaylistCategory(
		@Query("cookie") cookie: String? = null,

		): PlaylistCategoryResponse

	/**
	 * 精品歌单标签列表
	 */
	@GET("playlist/highquality/tags")
	suspend fun getPlaylistTags(
		@Query("cookie") cookie: String? = null,
	): PlaylistTagsResponse

	/**
	 * 精品歌单列表
	 */
	@GET("top/playlist/highquality")
	suspend fun getHighQualityPlaylists(
		@Query("cat") category: String?,
		@Query("limit") limit: Int = 50,
		@Query("before") before: Long? = null,
		@Query("cookie") cookie: String? = null,

		): HighQualityPlaylistsResponse

	/**
	 * 收藏或取消收藏歌单
	 * @param type 1收藏 2取消收藏
	 */
	@GET("playlist/subscribe")
	suspend fun subscribePlaylist(
		@Query("id") id: Long,
		@Query("t") type: Int,
		@Query("cookie") cookie: String? = null,

		): CodeResponse

	/**
	 * 获取歌曲播放地址
	 */
	@GET("song/url/v1")
	suspend fun getSongUrl(
		@Query("id") id: Long,
		@Query("level") level: String = "jymaster",
		@Query("cookie") cookie: String? = null,

		): MusicUrlResponse

	/**
	 * 获取歌曲详情
	 */
	@GET("song/detail")
	suspend fun getSongDetail(
		@Query("ids") id: Long,
		@Query("cookie") cookie: String? = null,

		): SongDetailResponse


    /**
     * 是否喜欢歌曲
     */
    @GET("song/like/check")
    suspend fun isSongLiked(
        @Query("ids") ids: String,
        @Query("cookie") cookie: String,
    ): CheckSongLikeResponse

    /**
     * 喜欢歌曲
     */
    @GET("like")
    suspend fun likeSong(
        @Query("id") id: Long,
        @Query("like") like: Boolean,
        @Query("cookie") cookie: String,
    )


	/**
	 * 获取歌曲详情
	 */
	@GET("song/detail")
	suspend fun getSongsDetail(
		@Query("ids") ids: String,
		@Query("cookie") cookie: String? = null,

		): SongDetailResponse


	/**
	 * 收藏或取消收藏专辑
	 * @param action 1表示收藏 0表示取消收藏
	 */
	@GET("album/sub")
	suspend fun collectAlbum(
		@Query("id") albumId: Long,
		@Query("t") action: Int,
		@Query("cookie") cookie: String? = null,
	)


	/**
	 * 用户详情
	 */
	@GET("user/detail")
	suspend fun getUserDetail(
		@Query("uid") userId: Long, @Query("cookie") cookie: String? = null,
	): UserDetailResponse

	/**
	 * 用户详情
	 */
	@GET("user/detail")
	suspend fun userDetail(
		@Query("uid") userId: String, @Query("cookie") cookie: String,
	): UserDetailResponse

	@GET("user/account")
	suspend fun userAccount(
		@Query("cookie") cookie: String? = null,
	): UserAccountResponse

	@GET("user/level")
	suspend fun userLevel(
		@Query("cookie") cookie: String? = null,
	): UserLevelResponse

//    @GET("user/subcount")
//    suspend fun subcount(
//        @Query("cookie") cookie: String? = null,
//    )

	@GET("user/binding")
	suspend fun userBinding(
		@Query("cookie") cookie: String? = null,
	)

	/**
	 * 用户状态
	 * {"code":200,"data":{},"message":""} 可能是空
	 */
	@GET("user/social/status")
	suspend fun userStatus(
		@Query("uid") userId: String,
		@Query("cookie") cookie: String? = null,
	): UserCurrentStatusResponse

	/**
	 * 用户可选状态
	 */
	@GET("user/social/status/support")
	suspend fun userSupportStatus(
		@Query("cookie") cookie: String? = null,
	): UserSupportStatusResponse

	/**
	 * 获取用户动态
	 */
	@GET("user/event")
	suspend fun getUserEvent(
		@Query("uid") userId: Long, @Query("limit") limit: Int = 1000, @Query("cookie") cookie: String? = null,
	)


	/**
	 * 最新专辑
	 * @param area ALL:全部,ZH:华语,EA:欧美,KR:韩国,JP:日本
	 */
	@GET("album/new")
	suspend fun getNewAlbumList(
		@Query("area") area: String,
		@Query("limit") limit: Int,
		@Query("offset") offset: Int,
		@Query("cookie") cookie: String? = null,

		): NewAlbumListResponse

	/**
	 * 获取歌手列表
	 * @param type -1全部 1男歌手 2女歌手 3乐队
	 * @param area -1全部  7华语 96欧美 8日本 16韩国 0其他
	 */
	@GET("artist/list")
	suspend fun getArtistList(
		@Query("type") type: Int,
		@Query("area") area: Int,
		@Query("limit") limit: Int,
		@Query("offset") offset: Int,
		@Query("cookie") cookie: String,

		): ArtistListResponse


	/**
	 * 获取歌手信息和热门歌曲
	 */
	@GET("artists")
	suspend fun getArtists(
		@Query("id") artistId: Long, @Query("cookie") cookie: String? = null,
	): ArtistsResponse

	/**
	 * 根据歌手id查询相似歌手
	 */
	@GET("simi/artist")
	suspend fun getSimiArtist(
		@Query("id") artistId: Long, @Query("cookie") cookie: String? = null,
	): SimiArtistResponse

	/**
	 * 获取歌手专辑
	 */
	@GET("artist/album")
	suspend fun getArtistAlbums(
		@Query("id") artistId: Long,
		@Query("limit") limit: Int = 1000,
		@Query("cookie") cookie: String? = null,

		): ArtistAlbumResponse

	/**
	 * 歌手mv
	 */
	@GET("/artist/mv")
	suspend fun getArtistMv(
		@Query("id") artistId: Long,
		@Query("limit") limit: Int = 1000,
		@Query("cookie") cookie: String? = null,

		): ArtistMvResponse

	/**
	 * 获取全部mv
	 */
	@GET("mv/all")
	suspend fun getAllMv(
		@Query("type") type: String?,
		@Query("area") area: String?,
		@Query("limit") limit: Int,
		@Query("offset") offset: Int,
		@Query("cookie") cookie: String? = null,

		): MvAllResponse

	/**
	 * 获取歌曲歌词
	 */
	@GET("lyric")
	suspend fun getSongLrc(
		@Query("id") songId: Long,
		@Query("cookie") cookie: String? = null,

		): LrcResponse

	/**
	 * 关注歌手
	 * @param t 1表示收藏 0表示取消收藏
	 */
	@GET("artist/sub")
	suspend fun followArtist(
		@Query("id") artistId: Long,
		@Query("t") t: Int = 1,
		@Query("cookie") cookie: String? = null,
	)

	/**
	 * 相似mv
	 */
	@GET("simi/mv")
	suspend fun simiMvs(
		@Query("mvid") mvId: Long,
		@Query("cookie") cookie: String? = null,
	): SimiMvResponse

	/**
	 * mv详情
	 */
	@GET("mv/detail")
	suspend fun mvDetail(
		@Query("mvid") mvId: Long,
		@Query("cookie") cookie: String? = null,
	): MvDetailResponse

	@GET("mv/url")
	suspend fun mvUrl(
		@Query("id") mvId: Long,
		@Query("cookie") cookie: String? = null,
	): MvUrlResponse

	/**
	 * 每日推荐歌单
	 */
	@GET("recommend/resource")
	suspend fun recommendPlaylists(
		@Query("cookie") cookie: String? = null,
	): RecommendPlaylistsResponse

	/**
	 * 每日推荐歌曲
	 */
	@GET("recommend/songs")
	suspend fun recommendSongs(
		@Query("cookie") cookie: String? = null,
	): RecommendSongsResponse

	/**
	 * 每日推荐新歌
	 */
	@GET("personalized/newsong")
	suspend fun recommendNewSongs(
		@Query("cookie") cookie: String?,
		@Query("limit") limit: Int = 30,
	): RecommendNewSongsResponse

	/**
	 * 每日推荐视频
	 */
	@GET("video/timeline/recommend")
	suspend fun recommendVideos(
		@Query("cookie") cookie: String? = null,
	): RecommendVideosResponse

	/**
	 * 排行榜
	 */
	@GET("toplist")
	suspend fun toplist(
		@Query("cookie") cookie: String? = null
	): ToplistResponse

	/**
	 * 获取历史日推可用日期列表
	 */
	@GET("history/recommend/songs")
	suspend fun recommendSongsDate(@Query("cookie") cookie: String): RecommendSongsDateResponse

	/**
	 * 获取历史日推详情数据
	 * @param date 日期,通过历史日推可用日期列表接口获取,不能任意日期
	 */
	@GET("history/recommend/songs/detail")
	suspend fun recommendSongsByDate(
		@Query("date") date: String,
		@Query("cookie") cookie: String
	): RecommendSongsDateResponse

	/**
	 * 编辑用户状态
	 */
	@GET("user/social/status/edit")
	suspend fun updateUserStatus(
		@Query("content") content: String,
		@Query("type") type: String,
		@Query("iconUrl") iconUrl: String,
		@Query("actionUrl") actionUrl: String? = null,
		@Query("cookie") cookie: String
	)

	/**
	 * 相同状态的用户
	 */
	@GET("user/social/status/rcmd")
	suspend fun sameStatusUsers(@Query("cookie") cookie: String): SameStatusUsersResponse

	/**
	 * 热门歌手
	 */
	@GET("top/artists")
	suspend fun topArtists(@Query("cookie") cookie: String): TopArtistsResponse

	/**
	 * 精品歌单
	 */
	@GET("top/playlist/highquality")
	suspend fun topPlaylists(
		@Query("cookie") cookie: String,
		@Query("cat") category: String? = null,
		@Query("limit") limit: Int? = 50,
		@Query("before") before: Long? = 0,
	): PlaylistsResponse

	/**
	 * 精品歌单标签
	 */
	@GET("playlist/highquality/tags")
	suspend fun topPlaylistTags(@Query("cookie") cookie: String): TopPlaylistTagsResponse

//    /**
//     * 歌手详情动态
//     */
//    @GET("artist/detail/dynamic")
//    suspend fun artistDynamic(
//        @Query("id") id: Long,
//        @Query("cookie") cookie: String
//    )

	/**
	 * 歌手详情
	 */
	@GET("artist/detail")
	suspend fun artistDetail(
		@Query("id") id: Long,
		@Query("cookie") cookie: String
	): CodeDataResponse<ArtistDetailResponse>

//    /**
//     * 歌手百科
//     */
//    @GET("ugc/artist/get")
//    suspend fun artistUgc(
//        @Query("id") id: Long,
//        @Query("cookie") cookie: String
//    )

	/**
	 * 歌手粉丝数量
	 */
	@GET("artist/follow/count")
	suspend fun artistFansCount(
		@Query("id") id: Long,
		@Query("cookie") cookie: String
	): CodeDataResponse<ArtistFansCountResponse>

	/**
	 * 歌手粉丝
	 */
	@GET("artist/fans")
	suspend fun artistFans(
		@Query("id") id: Long,
		@Query("offset") offset: Int = 0,
		@Query("limit") limit: Int = 20,
		@Query("cookie") cookie: String,
	): CodeDataResponse<List<ArtistFansResponse>>

	/**
	 * 歌手描述
	 */
	@GET("artist/desc")
	suspend fun getArtistDesc(
		@Query("id") id: Long, @Query("cookie") cookie: String
	): ArtistDescResponse

	/**
	 * 歌手热门50首歌曲
	 */
	@GET("artist/top/song")
	suspend fun artistHotSongs(
		@Query("id") id: Long, @Query("cookie") cookie: String
	): ArtistHotSongsResponse

	/**
	 * 用户动态
	 */
	@GET("user/event")
	suspend fun userEvent(
		@Query("uid") uid: String,
		@Query("limit") limit: Int = 30,
		@Query("lasttime") lastTime: Long = -1,
		@Query("cookie") cookie: String,
	)

	/**
	 * 热门话题
	 */
	@GET("hot/topic")
	suspend fun hotTopics(
		@Query("offset") offset: Int = 0,
		@Query("limit") limit: Int = 20,
		@Query("cookie") cookie: String,
	): HotTopicsResponse

	@GET("event")
	suspend fun events(
		@Query("pagesize") pageSize: Int = 20,
		@Query("lasttime") lastTime: Long = -1,
		@Query("cookie") cookie: String,
	): EventsResponse

    /**
     * 最近播放的歌曲
     */
    @GET("record/recent/song")
    suspend fun recentSongs(
        @Query("cookie") cookie: String,
        @Query("limit") limit: Int = 100,
    ):RecentSongsResponse

//    /**
//     * 话题详情
//     */
//    @GET("topic/detail")
//    suspend fun topicDetail(
//        @Query("actid") actid: Long = 115842105,
//        @Query("cookie") cookie: String)
//
//    /**
//     * 获取话题详情热门动态
//     */
//    @GET("topic/detail/event/hot")
//    suspend fun s(
//        @Query("actid") actid: Long = 115842105,
//        @Query("cookie") cookie: String
//    )
}