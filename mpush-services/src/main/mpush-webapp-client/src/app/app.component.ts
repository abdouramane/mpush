import { Component } from '@angular/core';
import { UserService } from "../users/users.service";
import { User } from "../users/user";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app';
  users : User[];

  constructor(private userService: UserService) {

  }

  ngOnInit() {
    this.userService.getAllUsers().then(users => this.users = users);
  }

}
