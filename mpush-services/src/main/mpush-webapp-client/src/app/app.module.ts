import { NgModule } from '@angular/core';
import { MatListModule } from '@angular/material';
import { HttpModule } from "@angular/http";
import { NgbModule } from "@ng-bootstrap/ng-bootstrap";
import { RouterModule, Routes } from "@angular/router";


import { AppComponent } from './app.component';
import { UserService } from "../models/users.service";
import { MenuComponent } from "./menu/menu.component";
import { LoginFormComponent } from './pages/login-form/login-form.component';
import { BrowserModule } from "@angular/platform-browser";
import { LoginService } from "./pages/login-form/login.service";
import { ContactComponent } from './pages/contact/contact.component';
import { AuthGuard } from "./auth.guard";
import { HomeComponent } from './pages/home/home.component';

const appRoutes: Routes = [
  {
    path: 'login',
    component: LoginFormComponent
  },
  {
    path: 'contacts',
    canActivate: [AuthGuard],
    component: ContactComponent
  },
  {
    path: 'home',
    canActivate: [AuthGuard],
    component: HomeComponent
  },
  {
    path: '',
    redirectTo: 'home',
    pathMatch: 'full',
  }
];

@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    LoginFormComponent,
    ContactComponent,
    HomeComponent
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
  providers: [UserService, LoginService, AuthGuard],
  bootstrap: [AppComponent]
})

export class AppModule { }
