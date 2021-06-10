package com.allion.ogoss.dto

class CommonResponce<T> {
    var newObject: T? =null
    var list: List<T>?=null
    var mutableList: MutableList<T?>?=null

    var code: String? = null
    var message: String? = null


}