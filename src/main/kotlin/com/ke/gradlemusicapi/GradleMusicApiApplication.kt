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

