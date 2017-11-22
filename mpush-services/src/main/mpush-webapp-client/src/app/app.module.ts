import { NgModule } from '@angular/core';
import { MatListModule, MatTableModule, MatPaginatorModule, MatFormFieldModule, MatInputModule, MatSortModule } from '@angular/material';
import { HttpModule } from "@angular/http";
import { NgbModule } from "@ng-bootstrap/ng-bootstrap";
import { RouterModule, Routes } from "@angular/router";


import { AppComponent } from './app.component';
import { MenuComponent } from "./menu/menu.component";
import { LoginFormComponent } from './pages/login-form/login-form.component';
import { BrowserModule } from "@angular/platform-browser";
import { LoginService } from "./pages/login-form/login.service";
import { ContactComponent } from './pages/contact/contact.component';
import { AuthGuard } from "./auth.guard";
import { HomeComponent } from './pages/home/home.component';
import { User } from "../models/user";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import { UserService } from "../models/users.service";

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
    HomeComponent,
  ],
  imports: [
    RouterModule.forRoot(
      appRoutes,
      {useHash: true}
    ),
    BrowserModule,
    HttpModule,
    MatListModule,
    NgbModule.forRoot(),
    MatTableModule,
    MatPaginatorModule,
    MatFormFieldModule,
    MatInputModule,
    MatSortModule,
    BrowserAnimationsModule
  ],
  providers: [UserService, LoginService, AuthGuard, User],
  bootstrap: [AppComponent]
})

export class AppModule { }
