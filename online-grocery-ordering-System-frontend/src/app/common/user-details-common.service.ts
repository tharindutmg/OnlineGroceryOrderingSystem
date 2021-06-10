import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { registration, USER_ADDRESS } from 'src/app/common/resturl';
import { UserDetails } from './user-details';
import { CONSTANTS } from './constants';

@Injectable()
export class UserDetailsCommonService {

    getUserDetails() {
        const value = localStorage.getItem(CONSTANTS.USER_DETAILS)
        var userDetailss : UserDetails = value !==null? JSON.parse(value):null;
        return userDetailss;
    }

    checkProfileComponent(){
        return 
    }

    

    
}