package com.alpha.ogo.service.impl;

import com.alpha.ogo.domain.Application;
import com.alpha.ogo.dto.CommonResponce;
import com.alpha.ogo.repo.ApplicationRepo;
import com.alpha.ogo.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Tharindu
 *
 * Jan 13, 2021
 */
@Service
public class ApplicationServiceImpl implements ApplicationService {
	
	@Autowired
	private ApplicationRepo applicationRepo;
	
	@Override
	public CommonResponce<Application> createApplication(Application application) {
		CommonResponce<Application> resopnce = new CommonResponce<Application>();
		try {
			application.setApplicationCode(application.getApplicationCode().toUpperCase());
			Application obj=applicationRepo.save(application);
			
			resopnce.setNewObject(obj);
			resopnce.setCode(CommonResponce.successCode);
			resopnce.setMessage(CommonResponce.successMessage);
			
		} catch (Exception e) {
			resopnce.setCode(CommonResponce.errorCode);
			resopnce.setMessage(CommonResponce.errorMessage);
		}
		
		return resopnce;
	}

	@Override
	public CommonResponce<Application> deleteApplication(Application application) {
		CommonResponce<Application> resopnce = new CommonResponce<Application>();
		try {
			
			Optional<Application> obj=applicationRepo.findById(application.getApplicationId());
			applicationRepo.delete(obj.get());
			
			resopnce.setCode(CommonResponce.successCode);
			resopnce.setMessage(CommonResponce.successMessage);
			
		} catch (Exception e) {
			resopnce.setCode(CommonResponce.errorCode);
			resopnce.setMessage(CommonResponce.errorMessage);
		}
		
		return resopnce;
	}

	@Override
	public CommonResponce<Application> getApplicationById(Application application) {
		CommonResponce<Application> resopnce = new CommonResponce<Application>();
		try {
			
			Optional<Application> obj=applicationRepo.findById(application.getApplicationId());
			
			resopnce.setNewObject(obj.get());
			resopnce.setCode(CommonResponce.successCode);
			resopnce.setMessage(CommonResponce.successMessage);
			
		} catch (Exception e) {
			resopnce.setCode(CommonResponce.errorCode);
			resopnce.setMessage(CommonResponce.errorMessage);
		}
		
		return resopnce;
	}

	@Override
	public CommonResponce<Application> getapplicationbyApplicationCode(String code) {
		CommonResponce<Application> resopnce = new CommonResponce<Application>();
		try {
			Application obj=applicationRepo.getApplicationbyApplicationCode(code.toUpperCase());
			resopnce.setNewObject(obj);
			resopnce.setCode(CommonResponce.successCode);
			resopnce.setMessage(CommonResponce.successMessage);
			
		} catch (Exception e) {
			resopnce.setCode(CommonResponce.errorCode);
			resopnce.setMessage(CommonResponce.errorMessage);
		}
		
		return resopnce;
	}

	@Override
	public CommonResponce<Application> getAllApplication() {
		CommonResponce<Application> resopnce = new CommonResponce<Application>();
		try {
			
			List<Application> objList=applicationRepo.getAllApplications();
			
			resopnce.setList(objList);
			resopnce.setCode(CommonResponce.successCode);
			resopnce.setMessage(CommonResponce.successMessage);
			
		} catch (Exception e) {
			resopnce.setCode(CommonResponce.errorCode);
			resopnce.setMessage(CommonResponce.errorMessage);
		}
		
		return resopnce;
	}

}
