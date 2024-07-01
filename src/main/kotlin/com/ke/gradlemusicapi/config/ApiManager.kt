package com.ke.gradlemusicapi.config

import com.ke.gradlemusicapi.api.HttpService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


@Configuration
class ApiManager {


	private fun okhttpClient(): OkHttpClient {

		val logger = HttpLoggingInterceptor {
			println(it)
		}.apply {
			level = HttpLoggingInterceptor.Level.BODY
		}

		return OkHttpClient.Builder()
			.addNetworkInterceptor(logger)
			.addInterceptor { chain ->
				val original = chain.request()
				val request = original.newBuilder()
					.url(
						original.url.newBuilder()
							.addQueryParameter("timestamp", System.currentTimeMillis().toString())
							.build()
					)
					.build()

				println(request.url.toString())

				chain.proceed(request)
			}
			.build()
	}

	@Bean
	fun createHttpService(): HttpService {
		return Retrofit.Builder()
			.baseUrl(
				"http://localhost:3000"
			)
			.addConverterFactory(MoshiConverterFactory.create())
			.client(okhttpClient())
			.build()
			.create(HttpService::class.java)
	}


}