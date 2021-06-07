package com.allion.ogoss.mapper

import com.allion.ogoss.domain.Registration
import com.allion.ogoss.domain.User
import org.apache.ibatis.annotations.*

@Mapper
interface RegistrationMapper {

    @Select("SELECT * FROM Registration WHERE nic=#{nic}")
    fun getRegistrationByNic(nic: String?): Registration?

    @Insert("INSERT INTO Registration(firstName,lastName,nic,mobile,email,addressLine1,addressLine2,addressLine3,userId,created_on,update_on) " +
            "VALUES(#{firstName}, #{lastName},#{nic},#{mobile},#{email},#{addressLine1},#{addressLine2},#{addressLine3},#{userId},#{created_on},#{update_on})")
    @Options(useGeneratedKeys=true, keyProperty="registrationId" )
    fun save(registration : Registration): Long

    @Update("UPDATE Registration SET firstName = #{firstName},lastName= #{lastName},nic= #{nic},mobile= #{mobile}," +
            "email= #{email}, addressLine1= #{addressLine1}, addressLine2= #{addressLine2},addressLine3= #{addressLine3}," +
            "userId= #{userId},update_on= #{update_on} WHERE registrationId = #{registrationId}")
    fun update(registration : Registration)

    @Select("SELECT * FROM Registration")
    fun findAll(): List<Registration>

    @Select("SELECT * FROM Registration WHERE registrationId=#{registrationId}")
    fun findById(registrationId : Long): Registration
}
