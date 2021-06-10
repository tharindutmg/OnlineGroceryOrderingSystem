package com.allion.ogoss.util

open class RestURL {
    companion object {
        const val USER : String ="user/"
        val ADMIN : String ="admin/"

        const val REGISTER :String = "register"
        //profile
        const val GET_USER_DETAILS : String = USER+"get-user-details"
        const val USER_ADDRESS : String = USER+"address"
        const val USER_ADDRESS_GET_ALL : String = USER+"address-get-all"
        const val USER_ADDRESS_GET_BY_ID : String = USER+"address-get-by-id"



    }
}