package com.alpha.ogo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.alpha.ogo.domain.Registration;
import com.alpha.ogo.domain.User;
import com.alpha.ogo.dto.CommonResponce;
import com.alpha.ogo.repo.RegistrationRepo;
import com.alpha.ogo.repo.UserRepo;
import com.alpha.ogo.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegistrationServiceImpl implements RegistrationService {
	
	@Autowired
	private RegistrationRepo registrationRepo;
	
	@Autowired
	UserRepo userRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public CommonResponce<Registration> createRegistration(Registration registration) {
		CommonResponce<Registration> resopnce = new CommonResponce<Registration>();
		
		try {
			if(registration.getRegistrationId() == null) {
				if(validateUserRegistration(registration)) {
					String encodedPassword = bCryptPasswordEncoder.encode(registration.getUser().getPassword());
					
					registration.getUser().setPassword(encodedPassword);
					registration.getUser().setRoles(CommonResponce.ROLE_USER);
					registration.getUser().setActive(true);
					
					User user= userRepository.save(registration.getUser());
					
					registration.setUserId(user.getId());
					
					registrationRepo.save(registration);
					resopnce.setNewObject(registration);
					resopnce.setCode(CommonResponce.successCode);
					resopnce.setMessage(CommonResponce.successMessage);
				}else {
					resopnce.setCode(CommonResponce.errorCode);
					resopnce.setMessage(CommonResponce.errorUserExist);
				}
			}else {
				User user= userRepository.save(registration.getUser());
				
				registration.setUserId(user.getId());
				
				registrationRepo.save(registration);
				resopnce.setNewObject(registration);
				resopnce.setCode(CommonResponce.successCode);
				resopnce.setMessage(CommonResponce.successMessage);
			}
		} catch (Exception e) {
			resopnce.setCode(CommonResponce.errorCode);
			resopnce.setMessage(CommonResponce.errorMessage);
		}
		
		return resopnce;
	}

	private boolean validateUserRegistration(Registration registration) {
		Registration obj =registrationRepo.getRegistrationByNic(registration.getNic());
		if(obj == null) 
			return true;
		else
			return false;
	}

	@Override
	public CommonResponce<User> checkUsername(String username) {
		CommonResponce<User> resopnce = new CommonResponce<User>();
		try {
			User user = userRepository.getByUserName(username);
			
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
	public CommonResponce<Registration> getAllUsers() {
		CommonResponce<Registration> resopnce = new CommonResponce<Registration>();
		try {
			
			List<Registration> mainList = new ArrayList<>();
			for(Registration registration : registrationRepo.findAll()) {
				
				for(User user :userRepository.findAll()) {
					
					if(registration.getUserId() == user.getId()) {
						registration.setUser(user);
					}
				}
				mainList.add(registration);
			}
			resopnce.setList(mainList);
			
		} catch (Exception e) {
			resopnce.setCode(CommonResponce.errorCode);
			resopnce.setMessage(CommonResponce.errorMessage);
		}
		return resopnce;
	}

	@Override
	public CommonResponce<Registration> getRegistrationById(String registrationId) {
		CommonResponce<Registration> resopnce = new CommonResponce<Registration>();
		try {
			
			Optional<Registration> regOpt = registrationRepo.findById(Long.parseLong(registrationId));
			
			Registration registration = regOpt.get();
			
			Optional<User> user = userRepository.findById(registration.getUserId());
			
			registration.setUser(user.get());
			
			resopnce.setNewObject(registration);
			
			resopnce.setCode(CommonResponce.successCode);
			resopnce.setMessage(CommonResponce.successMessage);
			
		} catch (Exception e) {
			resopnce.setCode(CommonResponce.errorCode);
			resopnce.setMessage(CommonResponce.errorMessage);
		}
		return resopnce;
	}

}
