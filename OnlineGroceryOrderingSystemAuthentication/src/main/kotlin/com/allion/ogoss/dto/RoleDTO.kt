package com.allion.ogoss.dto

import java.util.*

/**
 * @author  Tharindu
 * @date  6/3/2021 1:41 PM
 * @version 1.0
 */
class RoleDTO {
    var roleId: Long? = null
    var roleName: String? = null
    var roleCode: String? = null
    var check :Boolean = false
    var isActive :Boolean = false
    val createdAt: Date = Date()
    val updatedAt: Date = Date()
}