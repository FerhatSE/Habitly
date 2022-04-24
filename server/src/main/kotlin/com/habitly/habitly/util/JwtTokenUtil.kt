package com.habitly.habitly.util

import com.habitly.habitly.model.user.User
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.stereotype.Component
import java.util.*

@Component
class JwtTokenUtil {

    private val EXPIRATION = 24 * 60 * 60 * 1000 // 24h
    private val SECRET = "placeholder" // Placeholder secret key

    fun generateAccessToken(user: User): String {
        return Jwts.builder()
            .setIssuer(user.id.toString())
            .setExpiration(Date(System.currentTimeMillis() + EXPIRATION)) // One day
            .signWith(SignatureAlgorithm.HS512, SECRET)
            .compact()
    }
}