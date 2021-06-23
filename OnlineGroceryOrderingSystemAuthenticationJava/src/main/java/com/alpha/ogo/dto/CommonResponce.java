package com.alpha.ogo.dto;

import java.util.List;

import lombok.Data;

/**
 * @author Tharindu
 *
 * Dec 28, 2020
 */
@Data
public class CommonResponce<T> {
	
	public T newObject;
	public List<T> list;
	
	public String code;
	public String message;
	
	//User Roles
	public final static String ROLE_USER = "ROLE_USER";
	
	
	public final static String successCode = "1111";
	public final static String successMessage = "Success";
	public final static String loginSuccessMessage = "Login Success";
	
	public final static String errorCode = "0000";
	public final static String errorMessage = "Error";
	public final static String errorCodeRecordNotFound = "0001";
	public final static String errorMessageRecordNotFound = "Record Not Found";
	public final static String errorCodeInvalidLogin = "0011";
	public final static String errorMessageInvalidLogin = "Incorrect username or password";
	
	
	public final static String errorUserExist = "User already exist";

}
