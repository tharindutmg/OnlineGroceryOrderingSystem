package com.allion.ogoss.domain

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*
import javax.persistence.*
import kotlin.jvm.Transient

//@Entity
//@Table(name = "USER_REGISTER")
class Registration {

    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "U_REG_ID")
    var registrationId: Long? = null

    //@Column(name = "FIRST_NAME")
    var firstName: String? = null

   // @Column(name = "LAST_NAME")
    var lastName: String? = null

   // @Column(name = "NIC")
    var nic: String? = null

   // @Column(name = "MOBILE")
    var mobile: String? = null

    //@Column(name = "EMAIL")
    var email: String? = null

    //@Column(name = "ADDRESSLINE1")
    var addressLine1: String? = null

    //@Column(name = "ADDRESSLINE2")
    var addressLine2: String? = null

    //@Column(name = "ADDRESSLINE3")
    var addressLine3: String? = null

    //@Column(name = "USERID")
    var userId: Long? = 0

    @Transient
    var user: User? = null

    //@Column(nullable = false, updatable = false, name = "CREATED_ON")
    //@Temporal(TemporalType.TIMESTAMP)
    //@CreatedDate
    var created_on: Date? = null

    //@Column(nullable = false, name = "UPDATE_ON")
    //@Temporal(TemporalType.TIMESTAMP)
    //@LastModifiedDate
    var update_on: Date = Date()
}