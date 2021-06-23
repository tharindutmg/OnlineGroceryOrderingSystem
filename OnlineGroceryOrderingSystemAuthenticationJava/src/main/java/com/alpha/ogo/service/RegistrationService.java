
package com.alpha.ogo.service;

import com.alpha.ogo.domain.Registration;
import com.alpha.ogo.domain.User;
import com.alpha.ogo.dto.CommonResponce;

/**
 * @author Tharindu
 *
 */
public interface RegistrationService {

	CommonResponce<Registration> createRegistration(Registration registration);

	CommonResponce<User> checkUsername(String username);

	CommonResponce<Registration> getAllUsers();

	CommonResponce<Registration> getRegistrationById(String registrationId);

}
