import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { CONSTANTS } from '../common/constants';
import { UserDetails } from '../common/user-details';
import { User } from '../template/navigation-bar-section/model/user';
import { NavigationService } from '../template/navigation-bar-section/service/navigation.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private navigationService:NavigationService,public _router: Router,
    private toastr: ToastrService,) { }

  ngOnInit(): void {
  }

  mainModel = new User()

  invalidLogin:boolean=false;
  submit(){
    this.invalidLogin=false;
    this.navigationService.login(this.mainModel).subscribe(data =>{
      //debugger
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
        userDetails.email = data.newObject.email
        userDetails.fullName = data.newObject.fullName

        localStorage.setItem(CONSTANTS.USER_DETAILS, JSON.stringify(userDetails));
        
        const value = localStorage.getItem(CONSTANTS.USER_DETAILS)
        var userDetailss : UserDetails = value !==null? JSON.parse(value):null;
  
        //console.info(userDetailss.userToken);
        this.toastr.success('Create Success', data.message);
        
        location.reload();
        this._router.navigate(["/profile"]);
      }else{
        this.invalidLogin=true;
      }
    })
  }

}
