package com.allion.ogoss.security

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.http.MediaType
import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.AuthenticationEntryPoint
import org.springframework.stereotype.Component
import java.io.IOException
import java.util.*
import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


@Component
class JwtAuthenticationEntryPoint : AuthenticationEntryPoint {

    @Throws(ServletException::class, IOException::class)
    override fun commence(request: HttpServletRequest?, response: HttpServletResponse?, authException: AuthenticationException?) {
        response!!.status = HttpServletResponse.SC_UNAUTHORIZED
        response!!.contentType = MediaType.APPLICATION_JSON_VALUE

        val exception = request!!?.getAttribute("exception") as Exception?

        val message: String?

        if (exception != null) {
            message = if (exception.cause != null) {
                exception.cause.toString() + " " + exception.message
            } else {
                exception.message
            }
            val body = ObjectMapper().writeValueAsBytes(Collections.singletonMap("error", message))
            response!!.outputStream.write(body)
        } else {
            if (authException?.cause != null) {
                message = authException.cause.toString().toString() + " " + authException.message
            } else {
                message = authException?.message
            }
            val body = ObjectMapper().writeValueAsBytes(Collections.singletonMap("error", message))
            response!!.outputStream.write(body)
        }
    }
}