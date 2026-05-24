package com.ke.gradlemusicapi.config

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType
import io.swagger.v3.oas.models.Components
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@io.swagger.v3.oas.annotations.security.SecurityScheme(
	name = "Bearer Authentication",
	type = SecuritySchemeType.HTTP,
	bearerFormat = "JWT",
	scheme = "bearer"
)
class SpringDocConfig {

	@Bean
	fun customOpenApi(): OpenAPI {
		return OpenAPI()
			.info(
				Info()
					.title("Music API")
					.version("1.0.0")
					.description("网易云音乐 API")
			)
			.components(
				Components() // 设置 spring security jwt accessToken 认证的请求头 Authorization: Bearer xxx.xxx.xxx
//					.addSecuritySchemes(
//						"Authorization", SecurityScheme()
//							.type(SecurityScheme.Type.APIKEY)
//							.bearerFormat("JWT")
//							.scheme("basic")
//							.description("jwt token")
//					)
			)
	}
}