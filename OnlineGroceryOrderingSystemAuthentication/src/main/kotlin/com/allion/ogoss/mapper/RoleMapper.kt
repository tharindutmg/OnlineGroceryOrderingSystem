package com.allion.ogoss.mapper

import com.allion.ogoss.domain.Role
import com.allion.ogoss.domain.User
import org.apache.ibatis.annotations.*

@Mapper
interface RoleMapper {

    @Insert("INSERT INTO Role " +
            "VALUES(#{roleId},#{roleName},#{roleCode},#{isCheck},#{isActive},#{createdAt},#{updatedAt})")
    @Options(useGeneratedKeys=true, keyProperty = "roleId")
    fun save(role: Role)

    @Update("UPDATE Role SET roleName=#{roleName},roleCode=#{roleCode},isCheck=#{isCheck},isActive=#{isActive}," +
            "updatedAt=#{updatedAt} WHERE roleId=#{roleId}")
    fun update(user: Role)

    @Select("SELECT * FROM Role")
    fun findAll(): List<Role>?

    @Select("SELECT * FROM Role WHERE roleId=#{roleId}")
    fun findById(roleId: Long): Role?

    @Select("SELECT * FROM Role WHERE roleId=#{roleId}")
    fun getRolebyRoleCode(roleCode: String): Role?

    @Delete("DELETE FROM Role WHERE roleId=#{roleId}")
    fun delete(roleId: Long)

}
