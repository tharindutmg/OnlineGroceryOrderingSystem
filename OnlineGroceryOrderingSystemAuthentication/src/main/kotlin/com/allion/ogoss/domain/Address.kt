package com.allion.ogoss.domain

import java.util.*

/**
 * @author: Tharindu
 * @Date: 6/8/2021
 * @Time: 3:31 PM
 */
class Address {
    var addressId: Long? = null
    var userId : String? = null
    var fullName: String? = null
    var phoneNo: String? = null
    var province : String? = null
    var district : String? = null
    var city : String? = null
    var address : String? = null
    var location : String? = null

    val createdAt: Date = Date()
    val updatedAt: Date = Date()
}