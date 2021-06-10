package com.allion.ogoss.controller

import com.allion.ogoss.domain.Address
import com.allion.ogoss.domain.Registration
import com.allion.ogoss.domain.User
import com.allion.ogoss.dto.CommonResponce
import com.allion.ogoss.service.UserService
import com.allion.ogoss.util.RestURL
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@RestController
class UserController (private val userService : UserService): RestURL() {

    /*@PostMapping("register")
    @Throws(Exception::class)
    fun createRegistration(@RequestBody registration: Registration?): CommonResponce<Registration> {
        return registrationService.createRegistration(registration)
    }*/

    @PostMapping(REGISTER)
    @Throws(Exception::class)
    fun createRegistration(@RequestBody user: User?): CommonResponce<User> {
        return userService.createUserRegistration(user)
    }

    @PostMapping(USER_ADDRESS)
    @Throws(Exception::class)
    fun createAddress(@RequestBody address: Address?): CommonResponce<Address> {
        return userService.createUserAddress(address)
    }

    @PostMapping(USER_ADDRESS_GET_ALL)
    @Throws(Exception::class)
    fun getAllUserAddress(@RequestBody userId: Long?): CommonResponce<Address> {
        return userService.getAllUserAddress(userId)
    }

    @PostMapping(USER_ADDRESS_GET_BY_ID)
    @Throws(Exception::class)
    fun getAddressById(@RequestBody addressId: Long?): CommonResponce<Address> {
        return userService.getAddressById(addressId)
    }

    @PostMapping(GET_USER_DETAILS)
    @Throws(Exception::class)
    fun getUserDetailById(@RequestBody userId: Long?): CommonResponce<User> {
        return userService.getUserDetailById(userId)
    }

    @PostMapping("register/checkUsername")
    @Throws(Exception::class)
    fun checkUsername(@RequestBody username: String?): CommonResponce<User?>? {
        return userService.checkUsername(username)
    }

    @GetMapping("admin/register")
    @Throws(Exception::class)
    fun getAllUsers(): CommonResponce<Registration?>? {
        return userService.getAllUsers()
    }

    @PostMapping("admin/register/getRegistrationById")
    @Throws(Exception::class)
    fun getRegistrationById(@RequestBody registrationId: String?): CommonResponce<Registration?>? {
        return userService.getRegistrationById(registrationId)
    }

}