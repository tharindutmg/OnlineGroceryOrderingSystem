package com.alpha.ogo.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.alpha.ogo.domain.UserApp;
import com.alpha.ogo.dto.CommonResponce;
import com.alpha.ogo.repo.ApplicationRepo;
import com.alpha.ogo.repo.UserAppRepo;
import com.alpha.ogo.service.UserAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author Tharindu
 *
 * Jan 19, 2021
 */
@Service
public class UserAppServiceImpl implements UserAppService {
	
	@Autowired
	private UserAppRepo userAppRepo;
	@Autowired
	private ApplicationRepo applicationRepo;

	@Override
	public CommonResponce<UserApp> createUserApp(UserApp userApp) {
		CommonResponce<UserApp> resopnce = new CommonResponce<UserApp>();
		try {
			userApp.setAppIdList(userApp.getApplicationIdList());
			userApp.setUserId(userApp.getRegistrationId());
			UserApp userAppObj=userAppRepo.save(userApp);
			
			resopnce.setObject(userAppObj);
			resopnce.setCode(CommonResponce.successCode);
			resopnce.setMessage(CommonResponce.successMessage);
			
		} catch (Exception e) {
			resopnce.setCode(CommonResponce.errorCode);
			resopnce.setMessage(CommonResponce.errorMessage);
		}
		
		return resopnce;
	}

	@Override
	public CommonResponce<UserApp> deleteUserApp(UserApp userApp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommonResponce<UserApp> getUserAppById(UserApp userApp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommonResponce<UserApp> getAllUserApp() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommonResponce<UserApp> getUserAppByUserId(Long usserId) {
		CommonResponce<UserApp> resopnce = new CommonResponce<UserApp>();
		List<Long> appIdIntList = new ArrayList<>();
		try {
			UserApp userAppObj=userAppRepo.getUserAppByUserId(usserId);
			if(userAppObj!=null) {
				if(userAppObj.getAppIdList()!=null) {
					String[] appIdList =userAppObj.getAppIdList().split(",");
					
					for(String appId : appIdList) {
						appIdIntList.add(Long.parseLong(appId));
					}
					
					userAppObj.setAppList(applicationRepo.getApplicationsByApplicationIdList(appIdIntList));
				}
				
				
				//set application list to domain
				
				resopnce.setObject(userAppObj);
				resopnce.setCode(CommonResponce.successCode);
				resopnce.setMessage(CommonResponce.successMessage);
			}else {
				resopnce.setObject(userAppObj);
				resopnce.setCode(CommonResponce.errorCodeRecordNotFound);
				resopnce.setMessage(CommonResponce.errorMessageRecordNotFound);
			}
			
			
			
		} catch (Exception e) {
			resopnce.setCode(CommonResponce.errorCode);
			resopnce.setMessage(CommonResponce.errorMessage);
		}
		
		return resopnce;
	}

}
