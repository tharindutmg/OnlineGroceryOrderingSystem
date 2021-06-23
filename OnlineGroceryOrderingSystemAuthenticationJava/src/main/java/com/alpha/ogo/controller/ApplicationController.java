package com.alpha.ogo.controller;

import com.alpha.ogo.domain.Application;
import com.alpha.ogo.dto.CommonResponce;
import com.alpha.ogo.dto.CommonURL;
import com.alpha.ogo.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author Tharindu
 *
 * Jan 12, 2021
 */
@RestController
@CrossOrigin
public class ApplicationController {
	
	@Autowired
	private ApplicationService applicationService;
	
	private final String url = CommonURL.ADMIN+"/application";
	
	@PostMapping(CommonURL.application)
	public CommonResponce<Application> createApplication(@RequestBody Application application) throws Exception {
		return applicationService.createApplication(application);
	}
	
	@PostMapping(url+"/delete")
	public CommonResponce<Application> deleteApplication(@RequestBody Application application) {
	    return applicationService.deleteApplication(application);
	}

	
	@PostMapping(url+"/byId")
	public CommonResponce<Application> getApplicationById(@RequestBody Application application) throws Exception {
		return applicationService.getApplicationById(application);
	}
	
	@PostMapping(url+"/byCode")
	public CommonResponce<Application> getapplicationbyApplicationCode(@RequestBody String code) throws Exception {
		return applicationService.getapplicationbyApplicationCode(code);
	}
	
	@GetMapping(CommonURL.application)
	public CommonResponce<Application> getAllApplication() throws Exception {
		return applicationService.getAllApplication();
		
	}

}
