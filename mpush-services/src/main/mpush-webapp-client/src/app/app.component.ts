import { Component } from '@angular/core';
import { UserService } from "../models/users.service";
import { User } from "../models/user";
import {LoginService} from "./pages/login-form/login.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  users : User[];

  constructor(private userService: UserService, private loginService: LoginService) {

  }

  ngOnInit() {
    this.userService.getAllUsers().then(users => this.users = users);
  }

}
