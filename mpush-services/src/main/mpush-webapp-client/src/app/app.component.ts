import { Component } from '@angular/core';
import {LoginService} from "./pages/login-form/login.service";
import {RegistrationService} from "./pages/registration-form/registration.service";
import {User} from "../models/user";
import {UserService} from "../models/users.service";


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  users : User[];

  constructor(private userService: UserService, private loginService: LoginService, private registrationService: RegistrationService) {

  }

  ngOnInit() {
    this.userService.getAllUsers().then(users => this.users = users);
  }

}
