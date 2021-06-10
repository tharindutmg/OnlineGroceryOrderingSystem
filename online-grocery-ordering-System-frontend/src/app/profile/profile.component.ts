import { Component, OnInit } from '@angular/core';
import { CONSTANTS } from '../common/constants';
import { UserDetailsCommonService } from '../common/user-details-common.service';
import { UserRegister } from '../registration/model/user-register';
import { RegistrationService } from '../registration/service/registration.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  constructor(private registrationService:RegistrationService,
              private userDetailsCommonService:UserDetailsCommonService) { }

  ngOnInit(): void {
    this.getUserDetailsById()
  }

  mainModel = new UserRegister()

  getUserDetailsById(){
    this.registrationService.getUserDetailsById(this.userDetailsCommonService.getUserDetails().ussrId).subscribe(res =>{
      if(res.code === CONSTANTS.CODE){
        this.mainModel = res.newObject
      }else{}
    })
  }
  


}
