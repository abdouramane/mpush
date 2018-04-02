import { Component } from '@angular/core';
import {LoginService} from "../../pages/login-form/login.service";
import {UserService} from "../user/user.service";

@Component({
  selector: 'mp-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})

export class MenuComponent {

  constructor(private userService: UserService, public loginService: LoginService) {}

}
