import { Component, OnInit } from '@angular/core';
import {User} from "../../core/models/user.model";
import {UserService} from "../../core/user/user.service";

@Component({
  selector: 'mp-nouveau',
  templateUrl: './nouveau.component.html',
  styleUrls: ['./nouveau.component.css']
})
export class NouveauComponent implements OnInit {
  currentUser : User;

  constructor(public userService: UserService) {
    this.userService.getCurrentUser().then(user => this.currentUser = user);
  }

  ngOnInit() {
  }

}
