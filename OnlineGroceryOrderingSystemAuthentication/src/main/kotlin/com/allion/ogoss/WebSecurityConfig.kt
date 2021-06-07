package com.allion.ogoss

import com.allion.ogoss.security.JwtAuthenticationEntryPoint
import com.allion.ogoss.security.JwtRequestFilter
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import org.springframework.web.cors.CorsConfiguration
import javax.servlet.http.HttpServletRequest


@Configuration
@EnableWebSecurity
class WebSecurityConfig (private var userDetailsService: UserDetailsService,
                         private var jwtRequestFilter: JwtRequestFilter,
                         private var jwtAuthenticationEntryPoint: JwtAuthenticationEntryPoint) : WebSecurityConfigurerAdapter() {

    @Autowired
    @Throws(java.lang.Exception::class)
    fun configureGlobal(auth: AuthenticationManagerBuilder) {
        auth.userDetailsService<UserDetailsService>(userDetailsService).passwordEncoder(passwordEncoder())
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder? {
        return BCryptPasswordEncoder()
    }

    @Bean
    @Throws(java.lang.Exception::class)
    override fun authenticationManagerBean(): AuthenticationManager? {
        return super.authenticationManagerBean()
    }

    @Throws(Exception::class)
    override fun configure(httpSecurity: HttpSecurity) {
        httpSecurity.cors().configurationSource { request: HttpServletRequest? -> CorsConfiguration().applyPermitDefaultValues() }
        httpSecurity.csrf().disable()
                .authorizeRequests()
                .antMatchers("/authenticate").permitAll()
                .antMatchers("/register").permitAll()
                .antMatchers("/register/checkUsername").permitAll() //.antMatchers("/admin").hasRole("ADMIN")
                //.antMatchers("/user").hasAnyRole("ADMIN", "USER")
                //.antMatchers("/*").permitAll()
                .antMatchers("/admin/*").hasRole("ADMIN")
                .antMatchers("/admin/*/*").hasRole("ADMIN")
                .antMatchers("/user/*").hasAnyRole("ADMIN", "USER")
                .antMatchers("/user/*/*").hasAnyRole("ADMIN", "USER") //.antMatchers("/*/*").permitAll() hasRole("ADMIN")
                .anyRequest().authenticated() //.and().exceptionHandling()
                .and().exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint)
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter::class.java)
    }
}