import {NgModule} from '@angular/core';
import {
  MatCheckboxModule, MatFormFieldModule, MatInputModule, MatListModule, MatPaginatorModule, MatSortModule,
  MatTableModule
} from '@angular/material';
import {HttpModule} from "@angular/http";
import {NgbModule} from "@ng-bootstrap/ng-bootstrap";
import {RouterModule, Routes} from "@angular/router";


import {AppComponent} from './app.component';
import {MenuComponent} from "./menu/menu.component";
import {LoginFormComponent} from './pages/login-form/login-form.component';
import {BrowserModule} from "@angular/platform-browser";
import {LoginService} from "./pages/login-form/login.service";
import {RegistrationService} from "./pages/registration-form/registration.service";
import {ContactComponent} from './pages/contact/contact.component';
import {AuthGuard} from "./auth.guard";
import {HomeComponent} from './pages/home/home.component';
import {RegistrationFormComponent} from './pages/registration-form/registration-form.component';
import {FormsModule} from '@angular/forms';
import {UserService} from "../models/users.service";
import {User} from "../models/user";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";

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
  },
  {
    path: 'registration',
    component: RegistrationFormComponent

  }
];

@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    LoginFormComponent,
    ContactComponent,
    HomeComponent,
    RegistrationFormComponent
  ],
  imports: [
    RouterModule.forRoot(
      appRoutes,
      {useHash: true}
    ),
    BrowserModule,
    FormsModule,
    HttpModule,
    MatListModule,
    MatTableModule,
    MatInputModule,
    MatPaginatorModule,
    MatFormFieldModule,
    MatInputModule,
    MatSortModule,
    BrowserAnimationsModule,
    MatCheckboxModule,
    NgbModule.forRoot()
  ],
  providers: [UserService, LoginService, AuthGuard, RegistrationService, User],
  bootstrap: [AppComponent]
})

export class AppModule { }
