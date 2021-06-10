package com.allion.ogoss.service.impl

import com.allion.ogoss.domain.Address
import com.allion.ogoss.domain.Registration
import com.allion.ogoss.domain.User
import com.allion.ogoss.dto.CommonResponce
import com.allion.ogoss.mapper.AddressMapper
import com.allion.ogoss.mapper.RegistrationMapper
import com.allion.ogoss.mapper.UserMapper
import com.allion.ogoss.service.UserService
import com.allion.ogoss.util.ControllerHelper
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import java.util.*


@Service
class UserServiceImpl (private var registrationRepo: RegistrationMapper,
                       private var userRepo: UserMapper,
                       private var addressMappse: AddressMapper
                                ) : UserService,ControllerHelper() {


    override fun createUserRegistration(user: User?): CommonResponce<User> {
        val response = CommonResponce<User>()
        try {
            if (user?.userId ==null) { // create user
                if (validateUserRegistration(user)) {
                    val encodedPassword: String = BCryptPasswordEncoder().encode(user?.password)
                    user?.password=encodedPassword
                    user?.roles= ROLE_USER
                    user?.active=true
                    user?.created_on=Date()
                    userRepo.save(user as User)

                    response.newObject = user
                    response.code = successCode
                    response.message = successMessage
                }

            } else{
                userRepo.update(user as User)
            }
        }catch (e: Exception) {
            println(e)
            response.code = errorCode
            response.message = errorMessage
        }
        return response
    }

    override fun createUserAddress(address: Address?): CommonResponce<Address> {
        val response = CommonResponce<Address>()
        try {
            if (address?.addressId ==null) { // create user
                addressMappse.save(address as Address)
            } else{ // update user
                addressMappse.update(address)
            }
            response.newObject = address
            response.code = successCode
            response.message = successMessage
        }catch (e: Exception) {
            println(e)
            response.code = errorCode
            response.message = errorMessage
        }
        return response
    }

    override fun getAllUserAddress(userId:Long?): CommonResponce<Address> {
        val response = CommonResponce<Address>()
        try {
            val mainList: MutableList<Address?> = addressMappse.getAllAddress(userId)
            response.mutableList=mainList
            response.code = successCode
            response.message = successMessage
        } catch (e: java.lang.Exception) {
            response.code = errorCode
            response.message = errorMessage
        }
        return response
    }

    override fun getAddressById(addressId: Long?): CommonResponce<Address> {
        val response = CommonResponce<Address>()
        try {
            val address: Address? = addressMappse.getAddressById(addressId)
            response.newObject=address
            response.code = successCode
            response.message = successMessage
        } catch (e: java.lang.Exception) {
            response.code = errorCode
            response.message = errorMessage
        }
        return response
    }

    override fun getUserDetailById(userId: Long?): CommonResponce<User> {
        val response = CommonResponce<User>()
        try {
            val user: User? = userRepo.findById(userId as Long)
            response.newObject=user
            response.code = successCode
            response.message = successMessage
        } catch (e: java.lang.Exception) {
            response.code = errorCode
            response.message = errorMessage
        }
        return response
    }


    override fun createRegistration(registration: Registration?): CommonResponce<Registration> {
        val response = CommonResponce<Registration>()

        try {
            if (registration?.registrationId == null) { // create user
                if (validateUserRegistration(registration?.user)) {
                    val encodedPassword: String = BCryptPasswordEncoder().encode(registration?.user?.password)
                    registration?.user?.password=encodedPassword
                    registration?.user?.roles= ROLE_USER
                    registration?.user?.active=true
                    registration?.user?.created_on=Date()
                    userRepo.save(registration?.user as User)
                    registration.created_on = Date()
                    registration.userId = registration.user?.userId

                    registrationRepo.save(registration)
                    response.newObject = registration
                    response.code = successCode
                    response.message = successMessage
                } else {
                    response.code = errorCode
                    response.message = errorUserExist
                }
            } else { //update user
                userRepo.update(registration.user as User)
                registration.userId=registration.user?.userId
                registration.update_on=Date()
                registrationRepo.update(registration)
                response.newObject=registration
                response.code = successCode
                response.message = successMessage
            }
        } catch (e: Exception) {
            println(e)
            response.code = errorCode
            response.message = errorMessage
        }

        return response
    }

    private fun validateUserRegistration(user: User?): Boolean {
        //val obj: Registration? = registrationRepo.getRegistrationByNic(registration?.nic)

        val phoneNo: String? = userRepo.getPhoneNoByPhoneNo(user?.phoneNo)
        val email: String? = userRepo.getEmailByEmail(user?.email)

        return phoneNo === null || email === null
    }

    override fun checkUsername(username: String?): CommonResponce<User?>? {
        val response = CommonResponce<User?>()
        try {
            val user: User? = userRepo.getByPhoneNo(username)
            if (user != null) {
                response.code = errorCode
                response.message = errorUserExist
            } else {
                response.code = successCode
            }
        } catch (e: java.lang.Exception) {
            response.code = errorCode
            response.message = errorMessage
        }
        return response
    }

    override fun getAllUsers(): CommonResponce<Registration?>? {
        val response = CommonResponce<Registration?>()
        try {
            val mainList: MutableList<Registration?> = ArrayList()
            for (registration in registrationRepo.findAll()) {
                for (user in userRepo.findAll()) {
                    if (registration?.userId === user?.userId) {
                        registration?.user=user
                    }
                }
                mainList.add(registration)
            }
            response.list=mainList
        } catch (e: java.lang.Exception) {
            response.code = errorCode
            response.message = errorMessage
        }
        return response
    }

    override fun getRegistrationById(registrationId: String?): CommonResponce<Registration?>? {
        val response = CommonResponce<Registration?>()
        try {
            val regOpt = registrationRepo.findById(registrationId!!.toLong())
            val registration :Registration = regOpt
            val user = userRepo.findById(registration.userId as Long)
            registration.user=user
            response.newObject=registration
            response.code = successCode
            response.message = successMessage
        } catch (e: java.lang.Exception) {
            response.code = errorCode
            response.message = errorMessage
        }
        return response
    }
}