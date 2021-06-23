package com.alpha.ogo.service;

import com.alpha.ogo.domain.Address;
import com.alpha.ogo.domain.User;
import com.alpha.ogo.dto.CommonResponce;

/**
 * @author Tharindu
 *
 * @Date Jun 18, 2021
 *
 */
public interface UserService {

	CommonResponce<User> createUser(User user);
	CommonResponce<User> checkUsername(String username);
	CommonResponce<User> getAllUsers();
	CommonResponce<User> getUserById(Long userId);
	
	CommonResponce<Address> createAddress(Address address);
	CommonResponce<Address> getAllUserAddress(Long userId);

}
