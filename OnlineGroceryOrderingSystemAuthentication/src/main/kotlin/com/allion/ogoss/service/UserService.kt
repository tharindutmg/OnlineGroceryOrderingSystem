package com.allion.ogoss.service

import com.allion.ogoss.domain.Address
import com.allion.ogoss.domain.Registration
import com.allion.ogoss.domain.User
import com.allion.ogoss.dto.CommonResponce

interface UserService {

    fun createUserRegistration(user: User?): CommonResponce<User>

    fun createUserAddress(address: Address?): CommonResponce<Address>

    fun getAllUserAddress(userId :Long?): CommonResponce<Address>

    fun getAddressById(addressId: Long?): CommonResponce<Address>

    fun getUserDetailById(userId: Long?): CommonResponce<User>


    fun createRegistration(registration: Registration?): CommonResponce<Registration>

    fun checkUsername(username: String?): CommonResponce<User?>?

    fun getAllUsers(): CommonResponce<Registration?>?

    fun getRegistrationById(registrationId: String?): CommonResponce<Registration?>?



}
