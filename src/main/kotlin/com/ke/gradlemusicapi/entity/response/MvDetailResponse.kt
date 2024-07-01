package com.ke.gradlemusicapi.entity.response

import com.ke.gradlemusicapi.entity.document.Artist
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MvDetailResponse(
	val data: MvDetailData
)

/**
 * {
 * 		"id": 14530277,
 * 		"name": "依靠",
 * 		"artistId": 10577,
 * 		"artistName": "周慧敏",
 * 		"briefDesc": "",
 * 		"desc": null,
 * 		"cover": "http://p1.music.126.net/sJJJstB2U_rwzKK3kefm1g==/109951167720868584.jpg",
 * 		"coverId_str": "109951167720868584",
 * 		"coverId": 109951167720868580,
 * 		"playCount": 3786,
 * 		"subCount": 43,
 * 		"shareCount": 2,
 * 		"commentCount": 5,
 * 		"duration": 254000,
 * 		"nType": 0,
 * 		"publishTime": "2014-12-18",
 * 		"price": null,
 * 		"brs": [{
 * 			"size": 17072888,
 * 			"br": 240,
 * 			"point": 0
 * 		}, {
 * 			"size": 27439738,
 * 			"br": 480,
 * 			"point": 2
 * 		}, {
 * 			"size": 42793888,
 * 			"br": 720,
 * 			"point": 5
 * 		}, {
 * 			"size": 123873400,
 * 			"br": 1080,
 * 			"point": 10
 * 		}],
 * 		"artists": [{
 * 			"id": 10577,
 * 			"name": "周慧敏",
 * 			"img1v1Url": "http://p1.music.126.net/AyMpC-0FrTVq--3ZN21HkQ==/109951168314010164.jpg",
 * 			"followed": false
 * 		}],
 * 		"commentThreadId": "R_MV_5_14530277",
 * 		"videoGroup": []
 * 	}
 */
@JsonClass(generateAdapter = true)
data class MvDetailData(
	val id: Long,
	val name: String,
	val artistId: Long,
	val artistName: String,
	val artists: List<Artist>,
	val playCount: Int,
	val subCount: Int,
	val shareCount: Int,
	val commentCount: Int,
	val cover: String
)
