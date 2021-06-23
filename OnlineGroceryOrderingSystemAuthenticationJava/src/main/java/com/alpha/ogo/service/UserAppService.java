package com.alpha.ogo.service;


import com.alpha.ogo.domain.UserApp;
import com.alpha.ogo.dto.CommonResponce;

/**
 * @author Tharindu
 *
 * Jan 19, 2021
 */
public interface UserAppService {

	CommonResponce<UserApp> createUserApp(UserApp userApp);

	CommonResponce<UserApp> deleteUserApp(UserApp userApp);

	CommonResponce<UserApp> getUserAppById(UserApp userApp);

	CommonResponce<UserApp> getAllUserApp();

	CommonResponce<UserApp> getUserAppByUserId(Long usserId);

}
