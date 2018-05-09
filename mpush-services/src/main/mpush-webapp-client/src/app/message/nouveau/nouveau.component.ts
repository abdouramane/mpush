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
  totalChar : number = 0; //Nombre total de caractères du message saisi
  nbSMS : number = 0; //Nombre de SMS à facturer
  message = ""; //Le message à envoyé

  constructor(public userService: UserService) {
    this.userService.getCurrentUser().then(user => this.currentUser = user);
  }

  ngOnInit() {
  }

  onKeyUp(event: any) {
    event.preventDefault();
    this.totalChar = this.message.length;
    this.nbSMS = Math.ceil(this.totalChar / 160);
  }

}
