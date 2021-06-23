package com.alpha.ogo.controller;

import com.alpha.ogo.dto.CommonResponce;
import com.alpha.ogo.security.AuthenticationRequest;
import com.alpha.ogo.security.AuthenticationResponse;
import com.alpha.ogo.security.JwtUtil;
import com.alpha.ogo.security.MyUserDetails;
import com.alpha.ogo.service.impl.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin
public class LoginController {
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtTokenUtil;

	@Autowired
	private LoginServiceImpl userDetailsService;
	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public CommonResponce<AuthenticationResponse> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
		CommonResponce<AuthenticationResponse> resopnce = new CommonResponce<AuthenticationResponse>();
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUserName(), authenticationRequest.getPassword()));
			
			final MyUserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUserName());
			final String jwt = jwtTokenUtil.generateToken(userDetails);
			
			resopnce.setCode(CommonResponce.successCode);
			resopnce.setMessage(CommonResponce.loginSuccessMessage);
			resopnce.setNewObject(new AuthenticationResponse(userDetails,jwt));
		}catch (BadCredentialsException e) {
			//throw new Exception("Incorrect username or password", e);
			resopnce.setCode(CommonResponce.errorCodeInvalidLogin);
			resopnce.setMessage(CommonResponce.errorMessageInvalidLogin);
		}
		
		return resopnce;
	}

}
