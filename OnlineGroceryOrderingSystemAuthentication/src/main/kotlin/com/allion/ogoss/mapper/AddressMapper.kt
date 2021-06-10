package com.allion.ogoss.mapper

import com.allion.ogoss.domain.Address
import org.apache.ibatis.annotations.*

/**
 * @author: Tharindu
 * @Date: 6/8/2021
 * @Time: 3:35 PM
 */
@Mapper
interface AddressMapper {

    @Insert("INSERT INTO Address(fullName,phoneNo,province,district,city,address,location," +
                                        "createdAt,updatedAt,userId) " +
            "VALUES(#{fullName}, #{phoneNo},#{province},#{district},#{city},#{address},#{location}," +
            "#{createdAt},#{updatedAt},#{userId})")
    @Options(useGeneratedKeys=true, keyProperty="addressId" )
    fun save(address : Address): Long

    @Update("UPDATE Address SET fullName = #{fullName},phoneNo=#{phoneNo},district= #{district},city= #{city}," +
            "address=#{address},location= #{location}," +
            "updatedAt= #{updatedAt} WHERE addressId = #{addressId}")
    fun update(address: Address)

    @Select("SELECT * FROM Address WHERE userId = #{userId}")
    fun getAllAddress(userId:Long?) : MutableList<Address?>

    @Select("SELECT * FROM Address WHERE addressId = #{addressId}")
    fun getAddressById(addressId: Long?): Address?
}