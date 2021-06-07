import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CONSTANTS } from '../Common/constants';
import { UserDetails } from '../Common/user-details';
import { Login } from './model/login';
import { LoginService } from './service/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  mainModel = new Login()

  constructor(private loginService:LoginService,public _router: Router) { }

  ngOnInit(): void {
  }
  invalidLogin:boolean=false;
  submit(){
    this.invalidLogin=false;
    this.loginService.login(this.mainModel).subscribe(data =>{
      debugger
      if(data.code === CONSTANTS.CODE){
        var role=new String( );
        for(let x=0;data.newObject.roles.length > x ; x++){
          role=role.concat(data.newObject.roles[x].authority +",");
        }
        localStorage.removeItem(CONSTANTS.USER_DETAILS);
        var userDetails = new UserDetails()
        userDetails.ussrId = data.newObject.userId
        userDetails.userName = data.newObject.userName
        userDetails.userRole = role.toString()
        userDetails.userToken = data.newObject.token
        
        localStorage.setItem(CONSTANTS.USER_DETAILS, JSON.stringify(userDetails));
        
        const value = localStorage.getItem(CONSTANTS.USER_DETAILS)
        var userDetailss : UserDetails = value !==null? JSON.parse(value):null;
  
        console.info(userDetailss.userToken);

        this._router.navigate(['/home']);
      }else{
        this.invalidLogin=true;
      }
    })
  }

}
