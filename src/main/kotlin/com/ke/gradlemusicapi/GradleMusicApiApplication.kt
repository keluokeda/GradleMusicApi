package com.ke.gradlemusicapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.http.server.reactive.ServerHttpRequest
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.User

@EnableReactiveMethodSecurity
@SpringBootApplication
class GradleMusicApiApplication

fun main(args: Array<String>) {
	runApplication<GradleMusicApiApplication>(*args)
}

val Authentication.user: User
	get() = this.principal as User

val Authentication.cookie: String
	get() = this.credentials.toString()

val ServerHttpRequest.ipAddress: String
	get() = this.remoteAddress?.address?.hostAddress ?: "unknown"

fun String?.levelName(): String? {
	return when (this) {
		"standard" -> "标准"
		"higher" -> "较高"
		"exhigh" -> "极高"
		"lossless" -> "无损"
		"hires" -> "Hi-Res"
		"jyeffect" -> "高清环绕声"
		"sky" -> "沉浸环绕声"
		"dolby" -> "杜比全景声"
		"jymaster" -> "超清母带"
		else -> null
	}
}

