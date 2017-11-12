import { Component, OnInit } from '@angular/core';
import { LoginService } from "./login.service";

@Component({
  selector: 'mp-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent implements OnInit {

  constructor(public loginService: LoginService) { }

  ngOnInit() {
  }

}
