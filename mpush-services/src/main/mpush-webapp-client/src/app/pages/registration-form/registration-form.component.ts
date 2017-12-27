import { Component, OnInit } from '@angular/core';
import { RegistrationService } from "./registration.service";


@Component({
  selector: 'mp-registration-form',
  templateUrl: './registration-form.component.html',
  styleUrls: ['./registration-form.component.css']
})
export class RegistrationFormComponent implements OnInit {

  constructor(public registrationService: RegistrationService) { }

  registerUser: any;
  confirmationPassword: string;
  errorToDisplay: string;
  success: boolean;
  failure: string;
  errorUserExists: string;

  ngOnInit() {
  this.success = false;
  this.registerUser = {};
  this.errorToDisplay = null;
  this.confirmationPassword="";
  }

  register() {
    if(this.registerUser.password !== this.confirmationPassword) {
      this.success = false;
      this.errorToDisplay = "ERR";
    }else {
      this.errorToDisplay = null;
      this.errorUserExists = null;
      this.registrationService.save(this.registerUser).subscribe(() =>
      {
        this.success = true;
        this.registerUser = {};
        this.confirmationPassword = "";
       },
       (response) => this.processError(response));
    }
  }

  private processError(response) {
    if(response.status == 409 && response.json().errorMessage == "USER_ALREADY_EXISTS"){
       this.errorUserExists='ERREUR';
    } else {
      this.failure = 'ECHEC';
    }
  }

}
