import { Component, OnInit, ViewChild, ViewChildren, QueryList } from '@angular/core';
import {
  FormBuilder,
  FormGroup,
  FormArray,
  FormControl,
  ValidatorFn
} from '@angular/forms';
import { RegistrationService } from '../registration/service/registration.service';
import { ToastrService } from 'ngx-toastr';
import { Registration } from '../registration/model/registration';
import { Role } from '../role/model/role';
import { RoleService } from '../role/service/role.service';

@Component({
  selector: 'app-user-roles',
  templateUrl: './user-roles.component.html',
  styleUrls: ['./user-roles.component.css']
})
export class UserRolesComponent implements OnInit {

  /* data table varible start*/
  filter: any = '';
  searchsearvice : any ='';
  p: number = 1;
  cp: number = 1;
  /* data table varible end*/

  registrationModel :Registration[]=[];

  mainModel = new Registration();

  emailPattern = "^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$";
  mobNumberPattern = "^(?:7|0|(\\+94?))[0-9]{9,10}$";
  nicPattern = "^([0-9]{9}[x|X|v|V]|[0-9]{12})$";

  statusArr = [{ title: "Active", value: true },
                { title: "Deactive", value: false }]

  rolsArray: Array<Role> = [];
  allRole :Array<Role> = [];

  ngOnInit(): void {
    this.getAllUsers();
  }

  constructor(private registrationService:RegistrationService,
              private toastr: ToastrService,
              private roleService : RoleService) { }

  submit(){
    const selectedRoles = this.allRole.filter( (role) => role.isCheck );
    
    var roleStr="";
    for(var i=0; i < selectedRoles.length;i++){
        roleStr += selectedRoles[i].roleCode+",";
    }
    this.mainModel.user.roles= roleStr.replace(/,\s*$/, "");
    this.mainModel.user.active = this.mainModel.active;

    this.registrationService.registration(this.mainModel).subscribe(data =>{
        console.info(data);
        if(data.code === "1111"){
          this.toastr.success('Create Success',data.message);
        }else{
          this.toastr.error('Somthing Wrong', data.message);
        }
        this.getAllUsers()
    });

  }

  getAllUsers(){
    this.registrationService.getAllUsers().subscribe(data =>{
      this.registrationModel=data.list;

      for(var i=0; i < this.registrationModel.length;i++){
        this.registrationModel[i].user.roles=this.registrationModel[i].user.roles.replaceAll("ROLE_", "");
        this.registrationModel[i].user.roles=this.registrationModel[i].user.roles.replaceAll("_", " ");
        
        if(this.registrationModel[i].user.active.toString() === "true"){
          this.registrationModel[i].user.active = "Active";
        }else{
          this.registrationModel[i].user.active = "Deactive";
        }
      }
    });
  }

  getRegistrationById(id:any){
    var roleArray=[]
    
    this.roleService.getAllRole().subscribe(data => {
      this.allRole=[]
      this.allRole = data.list;
      
      this.registrationService.getRegistrationById(id).subscribe(data => {
        this.mainModel=data.newObject;
        this.mainModel.active=data.newObject.user.active;
        this.mainModel.userName=data.newObject.user.userName;
        roleArray = data.newObject.user.roles.split(",");
        
        for(var j=0;j < this.allRole.length;j++){
          if(roleArray.includes(this.allRole[j].roleCode)){
            this.allRole[j].isCheck=true;
          }else{
            this.allRole[j].isCheck =false;
          }
        }
      });
    });
  }

}
