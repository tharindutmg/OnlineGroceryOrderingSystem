import { Component, OnInit } from '@angular/core';
import { CONSTANTS } from 'src/app/common/constants';
import { UserDetails } from 'src/app/common/user-details';

@Component({
  selector: 'app-upper-header-section',
  templateUrl: './upper-header-section.component.html',
  styleUrls: ['./upper-header-section.component.css']
})
export class UpperHeaderSectionComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
    
  }
  
  value = localStorage.getItem(CONSTANTS.USER_DETAILS)
  userDetails:UserDetails = this.value !==null? JSON.parse(this.value):new UserDetails();
  userName:String = this.userDetails?.fullName
  

}