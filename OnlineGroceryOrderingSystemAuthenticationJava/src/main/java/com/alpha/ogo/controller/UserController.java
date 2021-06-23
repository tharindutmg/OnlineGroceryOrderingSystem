package com.alpha.ogo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alpha.ogo.domain.Address;
import com.alpha.ogo.domain.User;
import com.alpha.ogo.dto.CommonResponce;
import com.alpha.ogo.dto.CommonURL;
import com.alpha.ogo.service.UserService;

/**
 * @author Tharindu
 * @Date Jun 18, 2021
 *
 */
@RestController
public class UserController extends CommonURL{
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping(REGISTER)
	public CommonResponce<User> createUser(@RequestBody User user) {
		return userService.createUser(user);
	}
	
	@PostMapping(ADDRESS)
	public CommonResponce<Address> createAddress(@RequestBody Address address) {
		return userService.createAddress(address);
	}
	
	@PostMapping(GET_ALL_USER_ADDRESS)
	public CommonResponce<Address> getAllUseAddress(@RequestBody Long userId) {
		return userService.getAllUserAddress(userId);
	}
	
	@PostMapping(USER_ADDRESS_GET_BY_ID)
	public CommonResponce<User> getAddressById(@RequestBody User user) {
		return userService.createUser(user);
	}
	
	@PostMapping(GET_USER_DETAILS)
	public CommonResponce<User> getUserDetailById(@RequestBody Long userId) {
		return userService.getUserById(userId);
	}

}
