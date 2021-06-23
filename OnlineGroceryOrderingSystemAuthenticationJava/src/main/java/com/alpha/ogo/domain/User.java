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

@Entity
@Table(name = "USER")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
@Data
public class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	//@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "VAM_USER_SEQ")
	//@SequenceGenerator(sequenceName = "vam_user_seq", allocationSize = 1, name = "VAM_USER_SEQ")
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="USER_ID")
    private Long id;
	
	@Column(name="FULL_NAME")
    private String fullName;
	
	@Column(name="PASSWORD")
    private String password;
	
	@Column(name="PHONE_NO")
	private String phoneNo;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="ACTIVE")
    private boolean active;
	
	@Column(name="ROLES") 
	private String roles;
	
	@Column(nullable = false, updatable = false,name = "CREATED_ON" )
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false,name = "UPDATE_ON")
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;
	
	/*
	 * @ManyToMany(cascade= CascadeType.ALL, fetch = FetchType.EAGER)
	 * 
	 * @JoinTable(name= "USERS_ROLES", joinColumns = @JoinColumn(name="USER_ID"),
	 * inverseJoinColumns = @JoinColumn(name="ROLE_ID"))
	 * 
	 * @Column(name="ROLES") private Set<Role> roles = new HashSet<>();
	 */
	
	/*	sequence table DDL
	 * 
	 * 	CREATE SEQUENCE vam_user_seq
		MINVALUE 1
		MAXVALUE 9999999999
		START WITH 4
		INCREMENT BY 1;

	*
	*/

}
