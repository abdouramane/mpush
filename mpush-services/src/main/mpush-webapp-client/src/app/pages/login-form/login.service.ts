import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { Router } from '@angular/router';
import {User} from "../../../users/user";


@Injectable()
export class LoginService {

  constructor(private http: Http, private router: Router) { }

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
              let user = data.json() as User;
              localStorage.setItem('currentUser', JSON.stringify({
                id : user.id,
                login : user.login,
                firstName : user.firstName,
                email : user.email
              }));
              // Call navigate to home
              this.router.navigate(['/']);
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

  isAuthenticated(): boolean {
    if(localStorage.getItem('currentUser') === null) {
      return false;
    }
    console.log(JSON.parse(localStorage.getItem('currentUser')).id != null);
    return JSON.parse(localStorage.getItem('currentUser')).id !== null;
  }

  private handleError(error: any): Promise<any> {
    return Promise.reject(error.message || error);
  }

}

interface ItemResponse {
  user: User;
}
