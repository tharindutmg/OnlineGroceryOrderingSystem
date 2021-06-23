package com.alpha.ogo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.alpha.ogo.domain.Address;
import com.alpha.ogo.domain.User;
import com.alpha.ogo.dto.CommonResponce;
import com.alpha.ogo.repo.AddressRepo;
import com.alpha.ogo.repo.UserRepo;
import com.alpha.ogo.service.UserService;

/**
 * @author Tharindu
 *
 * @Date Jun 18, 2021
 *
 */
@Service
public class UseServiceImpl implements UserService{
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private AddressRepo addressRepo;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public CommonResponce<User> createUser(User user) {
		CommonResponce<User> resopnce = new CommonResponce<User>();
		try {
			if(user.getId()==null) {
				if(validateUser(user)) {
					String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
					
					user.setPassword(encodedPassword);
					user.setRoles(CommonResponce.ROLE_USER);
					user.setActive(true);
					
					User savedUser=userRepo.save(user);
					resopnce.setNewObject(savedUser);
					resopnce.setCode(CommonResponce.successCode);
					resopnce.setMessage(CommonResponce.successMessage);
				}else {
					resopnce.setCode(CommonResponce.errorCode);
					resopnce.setMessage(CommonResponce.errorUserExist);
				}
			}else {
				User updatedUser=userRepo.save(user);
				resopnce.setNewObject(updatedUser);
				resopnce.setCode(CommonResponce.successCode);
				resopnce.setMessage(CommonResponce.successMessage);
			}
		
		} catch (Exception e) {
			resopnce.setCode(CommonResponce.errorCode);
			resopnce.setMessage(CommonResponce.errorMessage);
		}
		return resopnce;
	}
	
	private boolean validateUser(User user) {
		User obj =userRepo.getUserByPhoneNo(user.getPhoneNo());
		if(obj == null) 
			return true;
		else
			return false;
	}
	
	@Override
	public CommonResponce<User> checkUsername(String username) {
		CommonResponce<User> resopnce = new CommonResponce<User>();
		try {
			User user = userRepo.getByUserName(username);
			
			if(user !=null) {
				resopnce.setCode(CommonResponce.errorCode);
				resopnce.setMessage(CommonResponce.errorUserExist);
			}else {
				resopnce.setCode(CommonResponce.successCode);
			}
			
		} catch (Exception e) {
			resopnce.setCode(CommonResponce.errorCode);
			resopnce.setMessage(CommonResponce.errorMessage);
		}
		
		return resopnce;
	}

	@Override
	public CommonResponce<User> getAllUsers() {
		CommonResponce<User> resopnce = new CommonResponce<User>();
		try {
			List<User> allUser= userRepo.findAll();
			
			resopnce.setList(allUser);
			
		} catch (Exception e) {
			resopnce.setCode(CommonResponce.errorCode);
			resopnce.setMessage(CommonResponce.errorMessage);
		}
		return resopnce;
	}

	@Override
	public CommonResponce<User> getUserById(Long userId) {
		CommonResponce<User> resopnce = new CommonResponce<User>();
		try {
			Optional<User> user = userRepo.findById(userId);
			
			resopnce.setNewObject(user.get());
			resopnce.setCode(CommonResponce.successCode);
			resopnce.setMessage(CommonResponce.successMessage);
			
		} catch (Exception e) {
			resopnce.setCode(CommonResponce.errorCode);
			resopnce.setMessage(CommonResponce.errorMessage);
		}
		return resopnce;
	}
	
	@Override
	public CommonResponce<Address> createAddress(Address address) {
		CommonResponce<Address> resopnce = new CommonResponce<Address>();
		try {
			Address savedAddress=addressRepo.save(address);
			
			resopnce.setNewObject(savedAddress);
			resopnce.setCode(CommonResponce.successCode);
			resopnce.setMessage(CommonResponce.successMessage);
		} catch (Exception e) {
			resopnce.setCode(CommonResponce.errorCode);
			resopnce.setMessage(CommonResponce.errorMessage);
		}
		return resopnce;
	}
	
	@Override
	public CommonResponce<Address> getAllUserAddress(Long userId) {
		CommonResponce<Address> resopnce = new CommonResponce<Address>();
		try {
			List<Address> address=addressRepo.getAddressByUserId(userId);
			
			resopnce.setList(address);
			resopnce.setCode(CommonResponce.successCode);
			resopnce.setMessage(CommonResponce.successMessage);
		
		} catch (Exception e) {
			resopnce.setCode(CommonResponce.errorCode);
			resopnce.setMessage(CommonResponce.errorMessage);
		}
		
		return resopnce;
	}

}
