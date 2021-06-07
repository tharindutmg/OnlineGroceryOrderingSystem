import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, Router, RouterStateSnapshot } from '@angular/router';
import { Observable } from 'rxjs';
import { CONSTANTS } from '../Common/constants';
import { UserDetails } from '../Common/user-details';

@Injectable({
  providedIn: 'root'
})
export class RouteGuardService implements CanActivate {

  constructor(private router: Router) { }

  public canActivate(next: ActivatedRouteSnapshot) {
    const allowedRoles = next.data.allowedRoles;
    var isAuthorized = false;
    
    const value = localStorage.getItem(CONSTANTS.USER_DETAILS)
    var userDetails : UserDetails = value !==null? JSON.parse(value):null;

    const token = userDetails.userToken
    if (token) {
      //this check is token valid
      if (this.tokenExpired(token)) {// token expired 
        this.clearLocalStroage();
        
        if(this.router.url !== "register"){
          this.router.navigate(['login']);
        }
        
      } else { // token valid
        const roleStr = userDetails.userRole
        var roleLocalArr = roleStr !== null ? roleStr.split(",") : "";

        isAuthorized = roleLocalArr.includes(allowedRoles[0]);

        if (!isAuthorized) {
          this.router.navigate(['accessdenied']);
        }
      }
    }else{
      this.router.navigate(['login']);
    }

    return isAuthorized;
  }

  private tokenExpired(token: string) {
    const expiry = (JSON.parse(atob(token.split('.')[1]))).exp;
    return (Math.floor((new Date).getTime() / 1000)) >= expiry;
  }

  private clearLocalStroage() {
    localStorage.removeItem(CONSTANTS.USER_DETAILS);
  }
} 