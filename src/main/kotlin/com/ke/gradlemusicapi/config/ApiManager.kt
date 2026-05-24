package com.ke.gradlemusicapi.config

import com.ke.gradlemusicapi.api.HttpService
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory


@Configuration
class ApiManager {

    private val json = Json {
        ignoreUnknownKeys = true
        coerceInputValues = true
        isLenient = true

    }

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
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .client(okhttpClient())
            .build()
            .create(HttpService::class.java)
    }


}
