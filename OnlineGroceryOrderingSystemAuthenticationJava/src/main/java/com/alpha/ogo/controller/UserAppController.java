package com.alpha.ogo.controller;

import com.alpha.ogo.domain.UserApp;
import com.alpha.ogo.dto.CommonResponce;
import com.alpha.ogo.dto.CommonURL;
import com.alpha.ogo.service.UserAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author Tharindu
 *
 * Jan 19, 2021
 */
@RestController
@CrossOrigin
public class UserAppController {
	
	@Autowired
	private UserAppService userAppService;
	
	//private final String url = "admin/user-app";
	
	@PostMapping(CommonURL.use_app)
	public CommonResponce<UserApp> create(@RequestBody UserApp userApp) throws Exception {
		return userAppService.createUserApp(userApp);
	}
	
	@PostMapping(CommonURL.use_app_delete)
	public CommonResponce<UserApp> delete(@RequestBody UserApp userApp) {
	    return userAppService.deleteUserApp(userApp);
	}

	
	@PostMapping(CommonURL.use_app_userAppbyId)
	public CommonResponce<UserApp> getById(@RequestBody UserApp userApp) throws Exception {
		return userAppService.getUserAppById(userApp);
	}
	
	
	@GetMapping(CommonURL.use_app)
	public CommonResponce<UserApp> getAll() throws Exception {
		return userAppService.getAllUserApp();
		
	}
	
	@PostMapping(CommonURL.all_app_by_user_id)
	public CommonResponce<UserApp> getByUserId(@RequestBody String usserId) throws Exception {
		Long userId = Long.parseLong(usserId);
		return userAppService.getUserAppByUserId(userId);
	}

}
