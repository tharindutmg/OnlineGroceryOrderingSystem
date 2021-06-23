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
 * Dec 31, 2020
 */

@Entity
@Table(name = "VAM_ROLE")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
@Data
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VAM_ROLE_SEQ")
	//@SequenceGenerator(sequenceName = "vam_role_seq", allocationSize = 1, name = "VAM_ROLE_SEQ")
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ROLE_ID")
    private Long roleId;
	
	@Column(name="ROLE_NAME")
    private String roleName;
	
	@Column(name="ROLE_CODE")
    private String roleCode;
	
	@Column(name="IS_CHECK")
    private boolean check;
	
	@Column(name="IS_ACTIVE")
    private boolean isActive;
	
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
	 * 	CREATE SEQUENCE vam_role_seq
		MINVALUE 1
		MAXVALUE 9999999999
		START WITH 4
		INCREMENT BY 1;

	*
	*/

}
