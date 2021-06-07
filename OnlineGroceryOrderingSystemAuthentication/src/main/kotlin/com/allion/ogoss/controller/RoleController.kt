package com.allion.ogoss.controller

import com.allion.ogoss.domain.Role
import com.allion.ogoss.dto.CommonResponce
import com.allion.ogoss.dto.RoleDTO
import com.allion.ogoss.service.RoleService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


/**
 * @author  Tharindu
 * @date  6/2/2021 6:23 PM
 * @version 1.0
 */

@RestController
class RoleController (private val roleService: RoleService){


    @PostMapping("admin/role")
    @Throws(Exception::class)
    fun createRole(@RequestBody role: Role): CommonResponce<Role?>? {
        return roleService.createRole(role)
    }

    @PostMapping("admin/role/delete")
    fun deleteRole(@RequestBody role: Role?): CommonResponce<Role?>? {
        return roleService.deleteRole(role)
    }


    @PostMapping("admin/role/rolebyId")
    @Throws(Exception::class)
    fun getRoleById(@RequestBody role: Role?): CommonResponce<Role?>? {
        return roleService.getRoleById(role)
    }

    @PostMapping("admin/role/rolebyRoleCode")
    @Throws(Exception::class)
    fun getrolebyRoleCode(@RequestBody role: String?): CommonResponce<Role?>? {
        return roleService.getrolebyRoleCode(role)
    }

    @GetMapping("admin/role")
    @Throws(Exception::class)
    fun getAllRole(): CommonResponce<Role?>? {
        return roleService.getAllRole()
    }

}