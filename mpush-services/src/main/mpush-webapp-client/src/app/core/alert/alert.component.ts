import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'mp-alert',
  templateUrl: './alert.component.html',
  styleUrls: ['./alert.component.css']
})
export class AlertComponent implements OnInit {
  private message: string;
  private success: boolean;
  private failure: boolean;

  constructor() {
    this.clearAll();
  }

  ngOnInit() {
  }

  setSuccess(message: string) : void {
    this.success = true;
    this.message = message;
    this.failure = false;
  }

  setFailure(message: string) : void {
    this.failure = true;
    this.message = message;
    this.success = false;
  }

  clearAll(): void {
    this.failure = false;
    this.message = "";
    this.success = false;
  }
}
