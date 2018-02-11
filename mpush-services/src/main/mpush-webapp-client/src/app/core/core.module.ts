import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {MenuComponent} from "./menu/menu.component";
import {UserComponent} from './user/user.component';
import {AppRoutingModule} from "../app-routing/app-routing.module";
import {RouterModule} from "@angular/router";
import {AlertComponent} from './alert/alert.component';

@NgModule({
  imports: [
    CommonModule,
    AppRoutingModule
  ],
  declarations: [
    MenuComponent,
    UserComponent,
    AlertComponent
  ],
  exports: [
    MenuComponent,
    UserComponent,
    AlertComponent,
    RouterModule
  ]
})
export class CoreModule { }
