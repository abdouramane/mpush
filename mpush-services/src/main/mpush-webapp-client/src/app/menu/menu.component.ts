import { Component } from '@angular/core';
import {LoginService} from "../pages/login-form/login.service";
import {UserService} from "../../models/users.service";

@Component({
  selector: 'mp-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})

export class MenuComponent {

  constructor(private userService: UserService, private loginService: LoginService) {}

}
