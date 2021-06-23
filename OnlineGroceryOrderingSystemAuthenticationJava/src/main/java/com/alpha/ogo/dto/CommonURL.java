package com.alpha.ogo.dto;

/**
 * @author Tharindu
 *
 * Jan 21, 2021
 */
public class CommonURL {
	
	public static final String ADMIN = "admin/";
	public static final String USER = "user/";
	
	public static final String REGISTER = "register";
	
	public static final String ADDRESS = USER+"address";
	public static final String GET_ALL_USER_ADDRESS = USER+"address-get-all";
	public static final String USER_ADDRESS_GET_BY_ID = USER+"address-get-by-id";
	public static final String GET_USER_DETAILS = USER+"get-user-details";
	
	//Application URLS
	public static final String application = ADMIN+"application";
	
	//User application
	public static final String use_app_user = USER+"user-app";
	public static final String use_app = ADMIN+"user-app";
	public static final String use_app_delete = use_app +"delete";
	public static final String use_app_userAppbyId = use_app +"userAppbyId";
	public static final String all_app_by_user_id = use_app_user +"all-app-by-user-id"; //all-app-by-user-id
	

}
