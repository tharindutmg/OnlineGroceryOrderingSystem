package com.allion.ogoss.controller

import com.allion.ogoss.domain.Registration
import com.allion.ogoss.domain.User
import com.allion.ogoss.dto.CommonResponce
import com.allion.ogoss.service.RegistrationService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@RestController
class RegistrationController (private val registrationService : RegistrationService){

    /*@PostMapping("register")
    @Throws(Exception::class)
    fun createRegistration(@RequestBody registration: Registration?): CommonResponce<Registration> {
        return registrationService.createRegistration(registration)
    }*/

    @PostMapping("register")
    @Throws(Exception::class)
    fun createRegistration(@RequestBody user: User?): CommonResponce<User> {
        return registrationService.createUserRegistration(user)
    }

    @PostMapping("register/checkUsername")
    @Throws(Exception::class)
    fun checkUsername(@RequestBody username: String?): CommonResponce<User?>? {
        return registrationService.checkUsername(username)
    }

    @GetMapping("admin/register")
    @Throws(Exception::class)
    fun getAllUsers(): CommonResponce<Registration?>? {
        return registrationService.getAllUsers()
    }

    @PostMapping("admin/register/getRegistrationById")
    @Throws(Exception::class)
    fun getRegistrationById(@RequestBody registrationId: String?): CommonResponce<Registration?>? {
        return registrationService.getRegistrationById(registrationId)
    }

}