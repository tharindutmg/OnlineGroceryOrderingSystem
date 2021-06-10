const mainURL="http://localhost:8080/";

export const admin = "admin/";
export const user = "user/";

export const login = mainURL + 'authenticate';
export const registration = mainURL + 'register';

//profile
export const GET_USER_DETAILS = mainURL + user+'get-user-details';
export const USER_ADDRESS = mainURL + user+'address';
export const USER_ADDRESS_GET_ALL = mainURL + user+'address-get-all';
export const USER_ADDRESS_GET_BY_ID = mainURL + user+'address-get-by-id';