import { Injectable } from '@angular/core';

import { Headers, Http } from '@angular/http';

import { User } from './user'
import { Observable } from "rxjs/Observable";


@Injectable()
export class UserService {

  constructor(private http: Http, public currentUser: User) {

  }


  private usersUrl = '/mpush/api/users';

  getAllUsers(): Promise<User[]> {
    return this.http.get(this.usersUrl)
      .toPromise()
      .then(response => response.json() as User[])
      .catch(this.handleError);
  }

  getUserById(userId) : Promise<User> {
    return this.http.get(this.usersUrl + '/' + userId)
      .toPromise()
      .then(response => response.json() as User)
      .catch(this.handleError);
  }

  getCurrentUser() {
    return this.getUserById(JSON.parse(sessionStorage.getItem('currentUser')).id);
  }

  isAuthenticated(): boolean {
    if(sessionStorage.getItem('currentUser')) {
      return JSON.parse(sessionStorage.getItem('currentUser'));
    }

    return false;
  }

  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error);
    return Promise.reject(error.message || error);
  }

}
