import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { registration, USER_ADDRESS, USER_ADDRESS_GET_ALL, USER_ADDRESS_GET_BY_ID } from 'src/app/common/resturl';
import { Address } from '../model/address-book';

@Injectable()
export class AddressBookService {
    

    constructor(private _http: HttpClient) { }

    saveAddress(address: Address) {
        return this._http.post<any>(USER_ADDRESS, address);
    }

    getAddressById(addressId: string) {
        return this._http.post<any>(USER_ADDRESS_GET_BY_ID, addressId);
    }

    getAllUserAddress(userId:any){
        return this._http.post<any>(USER_ADDRESS_GET_ALL,userId);
    }

    /* checkUserName(userName: string){
        return this._http.post<any>(checkUserName, userName);
    }

    getRegistrationById(id:any){
        return this._http.post<any>(getRegistrationById,id);
    } */

    
}