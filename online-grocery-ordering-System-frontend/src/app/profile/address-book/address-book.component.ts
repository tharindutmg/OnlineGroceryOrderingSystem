import { Component, OnInit, ViewChild } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { Alert } from 'src/app/common/alert';
import { CONSTANTS } from 'src/app/common/constants';
import { UserDetails } from 'src/app/common/user-details';
import { UserDetailsCommonService } from 'src/app/common/user-details-common.service';
import { UserRegister } from 'src/app/registration/model/user-register';
import { Address } from './model/address-book';
import { AddressBookService } from './service/address-book.service';
declare var jQuery: any;
@Component({
  selector: 'app-address-book',
  templateUrl: './address-book.component.html',
  styleUrls: ['./address-book.component.css']
})
export class AddressBookComponent implements OnInit {

  constructor(private addressBookService: AddressBookService,
    private toastr: ToastrService,
    private userDetailsCommonService: UserDetailsCommonService) { }

  ngOnInit(): void {
    this.getAllUserAddress()
  }

  mainModel = new Address()
  mainModelList !: Address[]
  alert = new Alert()
  mobNumberPattern = "^(?:7|0|(\\+94?))[0-9]{9,10}$"

  statusArr = [{ title: "Home", value: "Home" },
  { title: "Office", value: "Office" }]

  submit(addressForm: any) {
    this.mainModel.userId = this.userDetailsCommonService.getUserDetails().ussrId
    this.addressBookService.saveAddress(this.mainModel).subscribe(responce => {
      if (responce.code === CONSTANTS.CODE) {
        this.getAllUserAddress()
        addressForm.reset();
        //jQuery("#myModal").modal("hide");
        this.toastr.success('Create Success', responce.message);
      } else {
        this.toastr.error('Somthing Wrong', responce.message);

      }
    })
  }

  getAllUserAddress() {
    this.addressBookService.getAllUserAddress(this.userDetailsCommonService.getUserDetails().ussrId).subscribe(res => {
      if (res.code === CONSTANTS.CODE) {
        this.mainModelList = res.mutableList
      } else { }
    })
  }

  getAddressById(address: Address) {
    this.addressBookService.getAddressById(address.addressId).subscribe(res => {
      if (res.code === CONSTANTS.CODE) {
        this.mainModel = res.newObject
      } else { }
    })
  }

  modalOnclick() {
    this.mainModel = new Address()
    //this.alert = new Alert()
  }

}
