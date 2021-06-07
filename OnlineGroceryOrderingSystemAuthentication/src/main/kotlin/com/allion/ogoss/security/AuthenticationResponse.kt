package com.allion.ogoss.security

import com.allion.ogoss.domain.User
import org.springframework.security.core.GrantedAuthority

class AuthenticationResponse(var token: String?, user: User, role: Collection<GrantedAuthority?>?) {
    var userId: Long? = null
    var userName: String? = null
    var active = false
    var roles: Collection<GrantedAuthority?>? = role
    var email: String? = null
    var fullName: String? = null

    init {
        this.userId=user.userId
        this.userName=user.phoneNo
        this.active=user.active
        this.email =user.email
        this.fullName = user.fullName
    }
}