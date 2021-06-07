package com.allion.ogoss.controller

import com.allion.ogoss.domain.User
import com.allion.ogoss.dto.CommonResponce
import com.allion.ogoss.security.AuthenticationRequest
import com.allion.ogoss.security.AuthenticationResponse
import com.allion.ogoss.security.JwtUtil
import com.allion.ogoss.security.MyUserDetails
import com.allion.ogoss.service.impl.UserServiceImpl
import com.allion.ogoss.util.ControllerHelper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class LoginController (private var userServiceImpl: UserServiceImpl,private var jwtTokenUtil: JwtUtil) :ControllerHelper(){

    @Autowired
    private val authenticationManager: AuthenticationManager? = null

    @GetMapping("hello")
    fun hello():String = "hello kotlin"

    @PostMapping("/authenticate")
    fun authentication(@RequestBody authenticationRequest : AuthenticationRequest) :CommonResponce<AuthenticationResponse>{
        val commonResponce= CommonResponce<AuthenticationResponse>()
        try {
        authenticationManager?.authenticate(UsernamePasswordAuthenticationToken(authenticationRequest.userName, authenticationRequest.password))
        val userDetails : MyUserDetails = userServiceImpl.loadUserByUsername(authenticationRequest.userName)
            println(userDetails.username)
            val jwt : String? = jwtTokenUtil.generateToken(userDetails);

            if(jwt !==null){
                val user:User = userServiceImpl.getUserDetails(userDetails.userName)

                commonResponce.code = successCode
                commonResponce.message = successMessage
                commonResponce.newObject = AuthenticationResponse(jwt,user,userDetails.authorities)
            }

        }catch (e : BadCredentialsException) {
            commonResponce.code = errorCodeInvalidLogin
            commonResponce.message = errorMessageInvalidLogin

        }catch ( ex: UsernameNotFoundException){
            println("value not found")
        }
        return commonResponce
    }

}