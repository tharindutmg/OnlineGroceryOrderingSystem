import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { APPLICATIONNAME } from '../Common/common-url';
import { CONSTANTS } from '../Common/constants';
import { Role } from '../Common/role';
import { UserDetails } from '../Common/user-details';

@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.css']
})
export class NavigationComponent implements OnInit {


  userName : string ="";
  appName :string = APPLICATIONNAME 

  constructor(private router: Router) { }

  value:any = localStorage.getItem(CONSTANTS.USER_DETAILS)
  userDetails : UserDetails = this.value !==null? JSON.parse(this.value):null

  ngOnInit(): void {
    this.userName= this.userDetails.userName
  }

  logOut(){
    this.router.navigate([''])
    this.clearLocalStroage()
  }

  private clearLocalStroage(){
    localStorage.removeItem(CONSTANTS.USER_DETAILS)
  }

  get isAdmin() {
    const roleStr= this.userDetails.userRole
    var roleLocalArr = roleStr !== null ? roleStr.split(",") : ""

    return roleLocalArr.includes(Role.Admin)
  }

  hasRole(role:string){
    var roleStr="";
    var returnVal = false;
    var count = 0;
    var isAdmin = false;
    const roleval = this.userDetails.userRole
    roleStr= roleval !==null ? roleval : ""

    
    if(roleStr !== ""){
      var roleLocalArr = roleStr.split(",");
      var roleArray = role.split(",");
      if(roleArray.length == 1 && roleLocalArr.length == 1){
        
      }
      for(var i=0 ; i< roleLocalArr.length;i++){

        for(var x=0 ; x< roleArray.length;x++){
          if(roleLocalArr[i] === roleArray[x]){
            count++;
            /* if(){

            } */
          }
        }
      }
      if(roleArray.length == count){
        returnVal=true;
      }


    }
  return returnVal;
  }

}
