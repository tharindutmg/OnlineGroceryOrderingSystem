package com.alpha.ogo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.alpha.ogo.repo.UserRepo;
import com.alpha.ogo.service.RegistrationService;


@RestController
@CrossOrigin
public class RegistrationController {
	
	@Autowired
	private RegistrationService registrationService;
	
	@Autowired
	UserRepo userRepository;
	
	/*@PostMapping("register")
	public CommonResponce<Registration> createRegistration(@RequestBody Registration registration) throws Exception {
		return registrationService.createRegistration(registration);
		
	}
	
	@PostMapping("register/checkUsername")
	public CommonResponce<User> checkUsername(@RequestBody String username) throws Exception {
		return registrationService.checkUsername(username);
		
	}
	
	@GetMapping("admin/register")
	public CommonResponce<Registration> getAllUsers() throws Exception {
		return registrationService.getAllUsers();
		
	}
	
	@PostMapping("admin/register/getRegistrationById")
	public CommonResponce<Registration> getRegistrationById(@RequestBody String registrationId) throws Exception {
		return registrationService.getRegistrationById(registrationId);
	}*/
	
}
