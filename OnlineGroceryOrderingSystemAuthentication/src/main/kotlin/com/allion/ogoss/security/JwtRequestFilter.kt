package com.allion.ogoss.security

import com.allion.ogoss.service.impl.UserServiceImpl
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.filter.OncePerRequestFilter
import java.io.IOException
import javax.servlet.FilterChain
import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
@CrossOrigin
class JwtRequestFilter (private val userDetailsService: UserServiceImpl,
                        private val jwtUtil:JwtUtil): OncePerRequestFilter(){

    @Throws(ServletException::class, IOException::class)
    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, filterChain: FilterChain) {
        /*
		 * HttpServletRequest httpRequest = (HttpServletRequest) request;
		 * Enumeration<String> headerNames = httpRequest.getHeaderNames();
		 *
		 * if (headerNames != null) { while (headerNames.hasMoreElements()) {
		 * System.out.println("Header: " +
		 * httpRequest.getHeader(headerNames.nextElement())); } }
		 */
        val authorizationHeader = request.getHeader("Authorization")
        println(authorizationHeader)
        var username: String? = null
        var jwt: String? = null
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            jwt = authorizationHeader.substring(7)
            username = jwtUtil.extractUsername(jwt)
        }
        if (username != null && SecurityContextHolder.getContext().authentication == null) {
            val userDetails: UserDetails = this.userDetailsService.loadUserByUsername(username)
            if (jwtUtil.validateToken(jwt, userDetails)) {
                val usernamePasswordAuthenticationToken = UsernamePasswordAuthenticationToken(userDetails, null, userDetails.authorities)
                usernamePasswordAuthenticationToken.details = WebAuthenticationDetailsSource().buildDetails(request)
                SecurityContextHolder.getContext().authentication = usernamePasswordAuthenticationToken
            }
        }
        filterChain.doFilter(request, response)
    }

}