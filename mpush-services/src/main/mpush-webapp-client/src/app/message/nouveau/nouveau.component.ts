import { Component, OnInit } from '@angular/core';
import {User} from "../../core/models/user.model";
import {UserService} from "../../core/user/user.service";
import {Message} from "../../core/models/message.model";
import {MessageService} from "../message.service";
declare var jquery:any;
declare var $ :any;

@Component({
  selector: 'mp-nouveau',
  templateUrl: './nouveau.component.html',
  styleUrls: ['./nouveau.component.css']
})
export class NouveauComponent implements OnInit {
  notification: string = "";
  success: boolean = false;
  failure: boolean = false;
  currentUser : User;
  totalChar : number = 0; //Nombre total de caractères du message saisi
  nbSMS : number = 0; //Nombre de SMS à facturer
  message : Message = new Message(); //Le message à envoyé

  constructor(public userService: UserService, public messageService: MessageService) {
    this.userService.getCurrentUser().then(user => this.currentUser = user);
  }

  ngOnInit() {
  }

  onKeyUp(event: any) {
    event.preventDefault();
    this.totalChar = this.message.content.length;
    this.nbSMS = Math.ceil(this.totalChar / 160);
  }

  sendMessage() {
    console.log($("#destinataires").val());

    this.message.userId = this.currentUser.id;
    this.message.destinataires = $("#destinataires").val();
    this.messageService.sendMessage(this.message).then(
      response => { console.log(response); this.setSuccess("Message sent."); },
      error => { console.log(error); this.setFailure("Error message feature not implemeted yet.")}
    );
  }

  setSuccess(message: string) : void {
    this.success = true;
    this.notification = message;
    this.failure = false;
  }

  setFailure(message: string) : void {
    this.failure = true;
    this.notification = message;
    this.success = false;
  }

  clearAll(): void {
    this.failure = false;
    this.notification = "";
    this.success = false;
  }

}
