package com.allion.ogoss.mapper

import com.allion.ogoss.domain.User
import org.apache.ibatis.annotations.*
import java.util.*

@Mapper
interface UserMapper  {

     @Insert("INSERT INTO User(fullName,phoneNo,email,password,active,roles,created_on,update_on)" +
             "VALUES(#{fullName},#{phoneNo},#{email},#{password},#{active},#{roles},#{created_on},#{update_on})")
     @Options(useGeneratedKeys=true, keyProperty = "userId")
     fun save(user : User)

     @Update("UPDATE User SET fullName = #{fullName},phoneNo=#{phoneNo},password= #{password},active= #{active}," +
             "email=#{email},roles= #{roles}," +
             "update_on= #{update_on} WHERE userId = #{userId}")
     fun update(user:User)

     //@Select("SELECT * FROM User WHERE userName = #{userName}")
    // fun findByUserName(userName: String): Optional<User>

     //@Select("SELECT * FROM User WHERE userName = #{userName}")
    // fun getByUserName(userName: String?): User?

     @Select("SELECT * FROM User WHERE phoneNo = #{phoneNo}")
     fun findByPhoneNo(phoneNo: String): Optional<User>

     @Select("SELECT * FROM User WHERE phoneNo = #{phoneNo}")
     fun getByPhoneNo(phoneNo: String?): User?


     @Select("SELECT * FROM User WHERE phoneNo = #{email}")
     fun findUserByEmail(email: String): Optional<User>

     @Select("SELECT * FROM User")
     fun findAll():List<User>

     @Select("SELECT * FROM User WHERE userId=#{id}")
     fun findById(userId :Long): User?

     @Select("SELECT phoneNo FROM User WHERE phoneNo = #{phoneNo}")
     fun getPhoneNoByPhoneNo(phoneNo: String?): String?

     @Select("SELECT email FROM User WHERE email = #{email}")
     fun getEmailByEmail(email: String?): String?

}
