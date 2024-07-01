package com.ke.gradlemusicapi.util

import com.squareup.moshi.JsonClass
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapter
import org.springframework.stereotype.Component
import org.springframework.util.FileCopyUtils
import org.springframework.util.ResourceUtils
import java.nio.charset.StandardCharsets
import java.nio.file.Files

@OptIn(ExperimentalStdlibApi::class)
@Component
class CityUtil {

	private val cityList by lazy {
		val jsonString = readJsFile()

		val adapter = Moshi.Builder().build().adapter<List<JsonCity>>()

		adapter.fromJson(jsonString)!!
	}


	fun convert(provinceId: Int, cityId: Int): Pair<String, String> {
		val province = cityList.firstOrNull {
			it.id == provinceId
		} ?: return "" to ""

		return province.name to (province.cities[cityId.toString()] ?: "")
	}

	private fun readJsFile(): String {
		val file = ResourceUtils.getFile("classpath:static/city.json")
		val inputStream = Files.newInputStream(file.toPath())
		val bytes = FileCopyUtils.copyToByteArray(inputStream)

		return String(bytes, StandardCharsets.UTF_8)
	}
}

/**
 *  {
 *     "id": 1,
 *     "name": "直辖市",
 *     "cities": {
 *       "110000": "北京市",
 *       "120000": "天津市",
 *       "310000": "上海市",
 *       "500000": "重庆市"
 *     }
 *   },
 */
@JsonClass(generateAdapter = true)
data class JsonCity(
	val id: Int,
	val name: String,
	val cities: Map<String, String>
)