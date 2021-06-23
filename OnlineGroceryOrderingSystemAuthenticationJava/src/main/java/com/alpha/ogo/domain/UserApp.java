package com.alpha.ogo.domain;

import java.util.Date;
import java.util.List;

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
 * Jan 19, 2021
 */

@Entity
@Table(name = "VAM_USER_APP")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
@Data
public class UserApp {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="USER_APP_ID")
    private Long userAppId;
	
	@Transient
	private Long registrationId;
	
	@Column(name="APP_ID")
    private String appIdList;
	
	@Transient
	private String applicationIdList;
	
	@Transient
	private List<Application> appList;
	
	@Column(name="USER_ID")
    private Long userId;
	
	@Column(name="CHECKED")
    private boolean checked;
	
	@Column(name="ACTIVE")
    private boolean active;
	
	@Column(nullable = false, updatable = false,name = "CREATED_ON" )
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false,name = "UPDATE_ON")
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

}
