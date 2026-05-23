package com.ke.gradlemusicapi.config

import com.ke.gradlemusicapi.entity.User
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.AuthorityUtils
import org.springframework.stereotype.Component
import java.util.*
import javax.crypto.SecretKey

@Component
class JwtManager {

	fun createToken(user: User): String {
		val builder = Jwts.builder()
			.subject(user.id)

			.claim("Cookie", user.cookie)
			.issuedAt(Date())
			.expiration(Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 30L))

		if (user.roles.isNotEmpty()) {
			builder.claim(AUTHORITIES_KEY, user.roles.joinToString(",") { it.name })
		}

		return builder.signWith(SECRET_KEY).compact()
	}

	fun parseToken(token: String): Authentication? {
		return try {
			val payload = Jwts.parser()
				.verifyWith(SECRET_KEY)
				.build()
				.parseSignedClaims(token)
				.payload

			val authoritiesClaim = payload[AUTHORITIES_KEY]
			val authorities =
				if (authoritiesClaim == null) emptyList<GrantedAuthority>()
				else AuthorityUtils.commaSeparatedStringToAuthorityList(authoritiesClaim.toString())

			val user = org.springframework.security.core.userdetails.User(payload.subject, "", authorities)
			UsernamePasswordAuthenticationToken(user, payload["Cookie"], authorities)
		} catch (e: Exception) {
			null
		}
	}

	companion object {
		private const val AUTHORITIES_KEY = "roles"
		private val SECRET_KEY: SecretKey = Keys.hmacShaKeyFor(
			Base64.getDecoder().decode("Q9eNsfrrmBPB2W5oQER7LGUefNmZhABbEetWls1knT6BEg6HkPv/DN9NQdadTQaEmBDY921+5h2TSqy/8fDUuw==")
		)
	}
}