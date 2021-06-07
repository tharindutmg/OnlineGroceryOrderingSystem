package com.allion.ogoss.domain

import java.util.*
import javax.persistence.Table

//@Entity
@Table(name = "user")
class User  {
    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "USER_ID")
    var userId: Long? =null

    //@Column(name = "USER_NAME")
    val fullName: String? = null

    val phoneNo: String? = null

    val email: String? = null

    //@Column(name = "PASSWORD")
    var password: String? = null

    //@Column(name = "ACTIVE")
    var active: Boolean = false

    //@Column(name = "ROLES")
    var roles: String? = null

   // @Column(nullable = false, updatable = false, name = "CREATED_ON")
    //@Temporal(TemporalType.TIMESTAMP)
    //@CreatedDate
    var created_on: Date = Date()

    //@Column(nullable = false, name = "UPDATE_ON")
    //@Temporal(TemporalType.TIMESTAMP)
    //@LastModifiedDate
    var update_on: Date=Date()
}