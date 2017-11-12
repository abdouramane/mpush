import { NgModule } from '@angular/core';
import { MatListModule } from '@angular/material';
import { HttpModule } from "@angular/http";
import { NgbModule } from "@ng-bootstrap/ng-bootstrap";
import { RouterModule, Routes } from "@angular/router";


import { AppComponent } from './app.component';
import { UserService } from "../users/users.service";
import { MenuComponent } from "./menu/menu.component";
import { LoginFormComponent } from './pages/login-form/login-form.component';
import { MainComponent } from './pages/main/main.component';
import { BrowserModule } from "@angular/platform-browser";
import { LoginService } from "./pages/login-form/login.service";

const appRoutes: Routes = [
  {
    path: '',
    component: MainComponent,
  }
];

@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    LoginFormComponent,
    MainComponent
  ],
  imports: [
    RouterModule.forRoot(
      appRoutes,
      {useHash: true}
    ),
    BrowserModule,
    HttpModule,
    MatListModule,
    NgbModule.forRoot()
  ],
  providers: [UserService, LoginService],
  bootstrap: [AppComponent]
})

export class AppModule { }
