import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CONSTANTS } from 'src/app/common/constants';
import { UserDetails } from 'src/app/common/user-details';
import { User } from './model/user';
import { NavigationService } from './service/navigation.service';

@Component({
  selector: 'app-navigation-bar-section',
  templateUrl: './navigation-bar-section.component.html',
  styleUrls: ['./navigation-bar-section.component.css']
})
export class NavigationBarSectionComponent implements OnInit {

  constructor(private navigationService:NavigationService,public _router: Router) { }

  ngOnInit(): void {
  }

  value = localStorage.getItem(CONSTANTS.USER_DETAILS)
  userDetails:UserDetails = this.value !==null? JSON.parse(this.value):new UserDetails();
  userName = this.userDetails.fullName

  mainModel = new User()

  invalidLogin:boolean=false;
  submit(){
    this.invalidLogin=false;
    this.navigationService.login(this.mainModel).subscribe(data =>{
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
        userDetails.email = data.newObject.email
        userDetails.fullName = data.newObject.fullName

        localStorage.setItem(CONSTANTS.USER_DETAILS, JSON.stringify(userDetails));
        
        const value = localStorage.getItem(CONSTANTS.USER_DETAILS)
        var userDetailss : UserDetails = value !==null? JSON.parse(value):null;
  
        console.info(userDetailss.userToken);

        this._router.navigate(["/profile"]);
      }else{
        this.invalidLogin=true;
      }
    })
  }

  logOut(){
    //this._router.navigate(["/home"])
    this.clearLocalStroage()
  }

  private clearLocalStroage(){
    localStorage.removeItem(CONSTANTS.USER_DETAILS)
  }

}
