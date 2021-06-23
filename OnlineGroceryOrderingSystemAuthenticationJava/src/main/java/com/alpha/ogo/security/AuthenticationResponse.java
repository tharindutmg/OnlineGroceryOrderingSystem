package com.alpha.ogo.security;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

import lombok.Data;

@Data
public class AuthenticationResponse implements Serializable {

    private final String token;
    private final Long userId;
    private final String userName;
    private final boolean active;
    private final Collection<? extends GrantedAuthority> roles;

	private final String email;
	private final String fullName;


    public AuthenticationResponse(MyUserDetails userDetails,String jwt) {
		super();
		this.token = jwt;
		this.userId = userDetails.getUserId();
		this.userName = userDetails.getUsername();
		this.active = userDetails.isEnabled();
		this.roles = userDetails.getAuthorities();
		this.email = userDetails.getEmail();
		this.fullName = userDetails.getFullName();
	}

	/*
	 * public String getJwt() { return token; }
	 */
}
