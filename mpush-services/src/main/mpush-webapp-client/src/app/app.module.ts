import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { MatListModule } from '@angular/material';
import { HttpModule } from "@angular/http";
import { NgbModule } from "@ng-bootstrap/ng-bootstrap";


import { AppComponent } from './app.component';
import { CustomersService } from "../customers/customers.service";
import { MenuComponent } from "./menu/menu.component";

@NgModule({
  declarations: [
    AppComponent,
    MenuComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    MatListModule,
    NgbModule.forRoot()
  ],
  providers: [CustomersService],
  bootstrap: [AppComponent]
})
export class AppModule { }
