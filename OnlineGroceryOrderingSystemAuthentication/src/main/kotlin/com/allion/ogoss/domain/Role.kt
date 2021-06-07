package com.allion.ogoss.domain

import java.util.*


class Role {
    var roleId: Long? = null
    var roleName: String? = null
    var roleCode: String? = null
    var isCheck :Boolean = false
    var isActive :Boolean = false
    val createdAt: Date = Date()
    val updatedAt: Date = Date()

}
