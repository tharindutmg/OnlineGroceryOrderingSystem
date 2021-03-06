package com.allion.ogoss.service.impl

import com.allion.ogoss.domain.User
import com.allion.ogoss.mapper.UserMapper
import com.allion.ogoss.security.MyUserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import java.util.function.Supplier


/**
 * @author: Tharindu
 * @Date: 6/8/2021
 * @Time: 4:03 PM
 */
@Service
class LoginServiceImpl(var userRepository : UserMapper) : UserDetailsService {


    override fun loadUserByUsername(userName:String) : MyUserDetails {
        val user = userRepository.findByPhoneNo(userName);
        user.orElseThrow(Supplier { UsernameNotFoundException("Not found: $userName") })
        return MyUserDetails(user.get());
    }

    fun getUserDetails(userName:String) : User {
        return userRepository.findByPhoneNo(userName).get();
    }
}