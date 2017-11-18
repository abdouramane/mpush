import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { Router } from '@angular/router';
import {User} from "../../../users/user";
import {UserService} from "../../../users/users.service";


@Injectable()
export class LoginService {

  constructor(private http: Http, private router: Router, private userServie: UserService) { }

  private loginUrl = '/mpush/login';
  private userUrl = '/mpush/api/users/';
  private currentUser: User = null;

  login(e): void {
    e.preventDefault();
    this.http.post(this.loginUrl, {login : e.target.elements['login'].value})
      .subscribe(
        data => {
          this.http.get(this.userUrl + data['_body']).subscribe(
            data => {
              // store login information in localStorage
              this.currentUser = data.json() as User;
              localStorage.setItem('currentUser', JSON.stringify({
                id : this.currentUser.id,
                login : this.currentUser.login,
                firstName : this.currentUser.firstName,
                email : this.currentUser.email
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
    localStorage.removeItem('currentUser');;
    this.router.navigate(['login']);
  }

  isAuthenticated(): boolean {
    if(localStorage.getItem('currentUser')) {
      console.log(JSON.parse(localStorage.getItem('currentUser')).id != null);
      return JSON.parse(localStorage.getItem('currentUser'));
    }

    return false;
  }

  getCurrentUser(): User {
    if(this.currentUser === null && JSON.parse(localStorage.getItem('currentUser'))) {
      this.currentUser = this.userServie.getUserBId(JSON.parse(localStorage.getItem('currentUser')).id);
    }
    return this.currentUser;
  }

  private handleError(error: any): Promise<any> {
    return Promise.reject(error.message || error);
  }

}

interface ItemResponse {
  user: User;
}
