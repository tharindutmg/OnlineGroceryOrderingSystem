package com.alpha.ogo.dto;

import com.alpha.ogo.domain.User;
import lombok.Data;

/**
 * @author Tharindu
 *
 * Dec 28, 2020
 */
@Data
public class RegistrationRequestDTO {
	
	private String registrationId;
	
	private String firstName;
	private String lastName;
	private String nic;
	private String mobile;
	private String email;
	
	private String addressLine1;
	private String addressLine2;
	private String addressLine3;
	
	private User user;

}
