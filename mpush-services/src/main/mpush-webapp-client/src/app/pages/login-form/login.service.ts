import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { Router } from '@angular/router';
import {User} from "../../core/models/user.model";
import {UserService} from "../../core/user/user.service";


@Injectable()
export class LoginService {

  constructor(private http: Http, private router: Router, private userServie: UserService) { }

  private loginUrl = '/mpush/login';
  private userUrl = '/mpush/api/users/';

  login(e): void {
    e.preventDefault();
    this.http.post(this.loginUrl, {login : e.target.elements['login'].value})
      .subscribe(
        data => {
          this.http.get(this.userUrl + data['_body']).subscribe(
            data => {
              // store login information in localStorage
              let user: User = data.json() as User;
              sessionStorage.setItem('currentUser', JSON.stringify({
                id : user.id,
                login : user.login,
                firstName : user.firstName,
                email : user.email
              }));
              // Call navigate to home
              this.router.navigate(['home']);
            },
            error => {
              this.handleError(error);
            }
          );
        },
        error => {
          this.handleError(error);
          //return false;
        });
  }

  logout(): void {
    sessionStorage.removeItem('currentUser');;
    this.router.navigate(['login']);
  }

  private handleError(error: any): Promise<any> {
    return Promise.reject(error.message || error);
  }

}
