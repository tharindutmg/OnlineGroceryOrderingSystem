import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { UserRegister } from '../model/user-register';
import { GET_USER_DETAILS, registration } from 'src/app/common/resturl';

@Injectable()
export class RegistrationService {
    constructor(private _http: HttpClient) { }

    registration(userRegister: UserRegister) {
        return this._http.post<any>(registration, userRegister);
    }

    getUserDetailsById(ussrId: string) {
        return this._http.post<any>(GET_USER_DETAILS, ussrId);
    }

    /* checkUserName(userName: string){
        return this._http.post<any>(checkUserName, userName);
    }

    getAllUsers(){
        return this._http.get<any>(getAllRegisterdUsers);
    }

    getRegistrationById(id:any){
        return this._http.post<any>(getRegistrationById,id);
    } */

    
}