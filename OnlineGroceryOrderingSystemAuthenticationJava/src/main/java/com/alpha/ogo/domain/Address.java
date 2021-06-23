package com.alpha.ogo.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/**
 * @author Tharindu
 *
 * @Date Jun 18, 2021
 *
 */

@Entity
@Table(name = "ADDRESS")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
@Data
public class Address {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ADDRESS_ID")
	private Long addressId;
	
	@Column(name="USER_ID")
	private String userId;
	
	@Column(name="FULL_NAME")
	private String fullName;
	
	@Column(name="PHONE_NO")
	private String phoneNo;
	
	@Column(name="PROVINCE")
	private String province;
	
	@Column(name="DISTRICT")
	private String district;
	
	@Column(name="CITY")
	private String city;
	
	@Column(name="ADDRESS")
	private String address;
	
	@Column(name="LOCATION")
	private String location;
	
	@Column(nullable = false, updatable = false,name = "CREATED_ON" )
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
	private Date createdAt;
	
	@Column(nullable = false,name = "UPDATE_ON")
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
	private Date updatedAt;

}
