import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../model/user';
import { login } from 'src/app/common/resturl';

@Injectable()
export class NavigationService {

    constructor(private _http: HttpClient) { }

    login(user: User) {
        console.info(this._http);
        return this._http.post<any>(login, user);
    }

    
}