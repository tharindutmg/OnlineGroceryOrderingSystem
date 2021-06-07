package com.allion.ogoss.service.impl

import com.allion.ogoss.domain.Role
import com.allion.ogoss.dto.CommonResponce
import com.allion.ogoss.mapper.RoleMapper
import com.allion.ogoss.service.RoleService
import com.allion.ogoss.util.ControllerHelper
import org.springframework.stereotype.Service


/**
 * @author  Tharindu
 * @date  6/2/2021 6:39 PM
 * @version 1.0
 */

@Service
class RoleServiceImpl (private var roleRepo : RoleMapper) : RoleService ,ControllerHelper()  {

    override fun createRole(role: Role?): CommonResponce<Role?>? {
        val response = CommonResponce<Role?>()
        try {
            if(role?.roleId==null){
                role?.roleCode=role?.roleCode?.toUpperCase()
                roleRepo.save(role as Role)
            }else{
                roleRepo.update(role)
            }

            response.newObject=role
            response.code = successCode
            response.message = successMessage
        } catch (e: Exception) {
            println(e)
            response.code = errorCode
            response.message = errorMessage
        }
        return response
    }

    override fun getAllRole(): CommonResponce<Role?>? {
        val response = CommonResponce<Role?>()
        try {
            val roleObjList: List<Role>? = roleRepo.findAll()
            response.list = roleObjList
            response.code = successCode
            response.message = successMessage
        } catch (e: java.lang.Exception) {
            response.code = errorCode
            response.message = errorMessage
        }
        return response
    }

    override fun getRoleById(role: Role?): CommonResponce<Role?>? {
        val response = CommonResponce<Role?>()
        try {
            val roleObj: Role? = roleRepo.findById(role?.roleId as Long)
            response.newObject=roleObj
            response.code = successCode
            response.message = successMessage
        } catch (e: java.lang.Exception) {
            response.code = errorCode
            response.message = errorMessage
        }
        return response
    }

    override fun getrolebyRoleCode(role: String?): CommonResponce<Role?>? {
        val response = CommonResponce<Role?>()
        try {
            val roleObj: Role? = roleRepo.getRolebyRoleCode(role as String)
            response.newObject = roleObj
            response.code = successCode
            response.message = successMessage
        } catch (e: java.lang.Exception) {
            response.code = errorCode
            response.message = errorMessage
        }
        return response
    }

    override fun deleteRole(role: Role?): CommonResponce<Role?>? {
        val response = CommonResponce<Role?>()
        try {
            roleRepo.delete(role?.roleId as Long)
            response.code = successCode
            response.message = successMessage
        } catch (e: java.lang.Exception) {
            response.code = errorCode
            response.message = errorMessage
        }
        return response
    }


}