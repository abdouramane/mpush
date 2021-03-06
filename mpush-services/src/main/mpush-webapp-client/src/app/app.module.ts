import {NgModule} from '@angular/core';
import {
  MatCheckboxModule, MatFormFieldModule, MatInputModule, MatListModule, MatPaginatorModule, MatSelectModule,
  MatSortModule, MatTableModule
} from '@angular/material';
import {HttpModule} from "@angular/http";
import {NgbModule} from "@ng-bootstrap/ng-bootstrap";


import {AppComponent} from './app.component';
import {LoginFormComponent} from './pages/login-form/login-form.component';
import {BrowserModule} from "@angular/platform-browser";
import {LoginService} from "./pages/login-form/login.service";
import {RegistrationService} from "./pages/registration-form/registration.service";
import {AuthGuard} from "./auth.guard";
import {HomeComponent} from './pages/home/home.component';
import {RegistrationFormComponent} from './pages/registration-form/registration-form.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {UserService} from "./core/user/user.service";
import {User} from "./core/models/user.model";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {SharedModule} from "./shared/shared.module";
import {CoreModule} from "./core/core.module";
import {MessageModule} from "./message/message.module";
import {ContactsModule} from "./contacts/contacts.module";

@NgModule({
  declarations: [
    AppComponent,
    LoginFormComponent,
    HomeComponent,
    RegistrationFormComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    FormsModule,
    HttpModule,
    MatListModule,
    MatTableModule,
    MatInputModule,
    MatPaginatorModule,
    MatFormFieldModule,
    MatInputModule,
    MatSortModule,
    MatCheckboxModule,
    MatSelectModule,
    NgbModule.forRoot(),
    ContactsModule,
    MessageModule,
    SharedModule,
    CoreModule
  ],
  providers: [UserService, LoginService, AuthGuard, RegistrationService, User],
  bootstrap: [AppComponent]
})

export class AppModule { }
