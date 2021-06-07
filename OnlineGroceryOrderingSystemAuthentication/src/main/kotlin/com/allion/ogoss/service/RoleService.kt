package com.allion.ogoss.service

import com.allion.ogoss.domain.Role
import com.allion.ogoss.dto.CommonResponce


interface RoleService {

    fun createRole(role: Role?): CommonResponce<Role?>?

    fun getAllRole(): CommonResponce<Role?>?

    fun getRoleById(role: Role?): CommonResponce<Role?>?

    fun getrolebyRoleCode(role: String?): CommonResponce<Role?>?

    fun deleteRole(role: Role?): CommonResponce<Role?>?

}
