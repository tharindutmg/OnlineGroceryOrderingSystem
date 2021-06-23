package com.alpha.ogo.service;


import com.alpha.ogo.domain.Application;
import com.alpha.ogo.dto.CommonResponce;

/**
 * @author Tharindu
 *
 * Jan 13, 2021
 */
public interface ApplicationService {

	CommonResponce<Application> createApplication(Application application);

	CommonResponce<Application> deleteApplication(Application application);

	CommonResponce<Application> getApplicationById(Application application);

	CommonResponce<Application> getapplicationbyApplicationCode(String code);

	CommonResponce<Application> getAllApplication();

}
