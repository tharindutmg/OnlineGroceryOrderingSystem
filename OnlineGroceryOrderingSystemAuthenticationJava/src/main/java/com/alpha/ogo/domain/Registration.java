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
import javax.persistence.Transient;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/**
 * @author Tharindu
 *
 * Dec 28, 2020
 */
@Entity
@Table(name = "VAM_USER_REGISTER")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
@Data
public class Registration {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VAM_U_REG_SEQ")
	//@SequenceGenerator(sequenceName = "vam_user_reg_seq", allocationSize = 1, name = "VAM_U_REG_SEQ")
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="U_REG_ID")
	private Long registrationId;
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	@Column(name="NIC")
	private String nic;
	
	@Column(name="MOBILE")
	private String mobile;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="ADDRESSLINE1")
	private String addressLine1;
	
	@Column(name="ADDRESSLINE2")
	private String addressLine2;
	
	@Column(name="ADDRESSLINE3")
	private String addressLine3;
	
	@Column(name="USERID")
	private long userId;
	
	@Transient
	private User user;
	
	@Column(nullable = false, updatable = false,name = "CREATED_ON" )
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false,name = "UPDATE_ON")
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;
	
	
	/*	sequence table DDL
	 * 
	 * 	CREATE SEQUENCE vam_user_reg_seq
		MINVALUE 1
		MAXVALUE 9999999999
		START WITH 4
		INCREMENT BY 1;

	*
	*/

}
