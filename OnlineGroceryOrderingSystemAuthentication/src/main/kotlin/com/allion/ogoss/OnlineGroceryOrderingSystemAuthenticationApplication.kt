package com.allion.ogoss

import com.allion.ogoss.domain.Address
import com.allion.ogoss.domain.Registration
import com.allion.ogoss.domain.Role
import com.allion.ogoss.domain.User
import org.apache.ibatis.type.MappedTypes
import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.runApplication

@MappedTypes(Registration::class,User::class, Role::class, Address::class)
@MapperScan("com.allion.ogoss.mapper")
@SpringBootApplication(exclude = [SecurityAutoConfiguration::class])
class OnlineGroceryOrderingSystemAuthenticationApplication

fun main(args: Array<String>) {
	runApplication<OnlineGroceryOrderingSystemAuthenticationApplication>(*args)
}
