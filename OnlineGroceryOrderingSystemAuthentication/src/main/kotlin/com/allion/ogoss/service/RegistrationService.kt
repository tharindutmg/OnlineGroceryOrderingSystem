package com.allion.ogoss.service

import com.allion.ogoss.domain.Registration
import com.allion.ogoss.domain.User
import com.allion.ogoss.dto.CommonResponce

interface RegistrationService {

    fun createRegistration(registration: Registration?): CommonResponce<Registration>

    fun createUserRegistration(user: User?): CommonResponce<User>

    fun checkUsername(username: String?): CommonResponce<User?>?

    fun getAllUsers(): CommonResponce<Registration?>?

    fun getRegistrationById(registrationId: String?): CommonResponce<Registration?>?

}
