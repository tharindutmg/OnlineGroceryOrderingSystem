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


    public AuthenticationResponse(String jwt,Long userId, String userName, boolean active,Collection<? extends GrantedAuthority> collection) {
		super();
		this.token = jwt;
		this.userId = userId;
		this.userName = userName;
		this.active = active;
		this.roles = collection;
	}

	/*
	 * public String getJwt() { return token; }
	 */
}
