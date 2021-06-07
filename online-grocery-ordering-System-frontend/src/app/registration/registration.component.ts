import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { CONSTANTS } from '../common/constants';
import { UserRegister } from './model/user-register';
import { RegistrationService } from './service/registration.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  constructor(private registrationService:RegistrationService,private toastr: ToastrService) { }

  ngOnInit(): void {
  }

  mainModel = new UserRegister();
  mobNumberPattern = "^(?:7|0|(\\+94?))[0-9]{9,10}$";
  emailPattern = "^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$";

  submit(registration:any){
    this.registrationService.registration(this.mainModel).subscribe(responce =>{
      if(responce.code === CONSTANTS.CODE){
        this.registrationService
        registration.reset();
        this.toastr.success('Create Success',responce.message);
      }else{
        this.toastr.error('Somthing Wrong', responce.message);
      }
    })

  }

}
