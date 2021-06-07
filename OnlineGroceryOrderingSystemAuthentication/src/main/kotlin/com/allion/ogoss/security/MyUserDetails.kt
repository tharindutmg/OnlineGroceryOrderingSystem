package com.allion.ogoss.security

import com.allion.ogoss.domain.User
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.*
import java.util.stream.Collectors

//import java.util.stream.Collectors


class MyUserDetails(user: User) :UserDetails {

    var userId: Long? = null
    var userName = ""
    private var pass :String = ""
    var active: Boolean  = false
    var authorities: MutableList<GrantedAuthority>? = null
    var fullName :String = ""
    var email : String = ""

    init {
        this.userId = user.userId
        this.fullName = user.fullName.toString()
        this.email = user.email.toString()
        this.userName= user.phoneNo.toString()
        this.pass = user.password.toString()
        this.active = user.active
        val userArr  =user.roles?.split(",")?.toTypedArray()
        this.authorities = Arrays.stream(userArr).map(::SimpleGrantedAuthority)
            .collect(Collectors.toList())
    }

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return this.authorities !!
    }


    override fun getPassword(): String {
        return this.pass
    }

    override fun getUsername(): String {
        return this.userName
    }

    override fun isAccountNonExpired(): Boolean {return true}

    override fun isAccountNonLocked(): Boolean {return true}

    override fun isCredentialsNonExpired(): Boolean {return true}

    override fun isEnabled(): Boolean =this.active

}