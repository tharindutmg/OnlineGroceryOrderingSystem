package com.allion.ogoss.security

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Service
import java.util.*
import java.util.function.Function


@Service
class JwtUtil {

    private val SECRET_KEY = "secret"

    fun extractUsername(token: String?): String? {
        return extractClaim(token) { obj: Claims? -> obj!!.subject }
    }

    fun extractExpiration(token: String?): Date? {
        return extractClaim(token) { obj: Claims? -> obj!!.expiration }
    }

    fun <T> extractClaim(token: String?, claimsResolver: Function<Claims?, T>): T {
        val claims: Claims = extractAllClaims(token)
        return claimsResolver.apply(claims)
    }

    private fun extractAllClaims(token: String?): Claims {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody()
    }

    private fun isTokenExpired(token: String): Boolean {
        return extractExpiration(token)!!.before(Date())
    }

    fun generateToken(userDetails: UserDetails): String? {
        val claims: Map<String, Any> = HashMap()
        println(userDetails.username)
        return createToken(claims, userDetails.username)
    }

    private fun createToken(claims: Map<String, Any>, subject: String): String? {
        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(Date(System.currentTimeMillis()))
                .setExpiration(Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact()
    }

    fun validateToken(token: String?, userDetails: UserDetails): Boolean {
        val username = extractUsername(token)
        return username == userDetails.username && !isTokenExpired(token!!)!!
    }
}