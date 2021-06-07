import { Component, OnInit } from '@angular/core';
import { Application } from '../application/model/application';
import { ApplicationService } from '../application/service/application.service';
import { CONSTANTS } from '../Common/constants';
import { UserDetails } from '../Common/user-details';
import { UserAppService } from '../user-app/service/user-app.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  applicationList: Application[]=[];

  constructor(private applicationService:ApplicationService,private userAppService:UserAppService,) { }

  ngOnInit(): void {
    this.getAllApplications();
  }

  getAllApplications(){
    const value = localStorage.getItem(CONSTANTS.USER_DETAILS)
    var userDetails : UserDetails = value !==null? JSON.parse(value):null;
    
    this.userAppService.getAllAppByUserId(userDetails.ussrId).subscribe(res =>{
      if (res.code === "1111"){
        this.applicationList = res.object.appList;
      }else{
        
      }
    });
  }

}
