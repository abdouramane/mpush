import { Injectable } from '@angular/core';

import { Headers, Http } from '@angular/http';

import { User } from './user'


@Injectable()

export class UserService {

  constructor(private http: Http) {

  }


  private usersUrl = '/mpush/api/users';

  getAllUsers(): Promise<User[]> {
    return this.http.get(this.usersUrl)
      .toPromise()
      .then(response => response.json() as User[])
      .catch(this.handleError);
  }

  getUserBId(id): User {

    if(!id) {
      this.handleError("id user passer en param est null");
      return null;
    }

    let user: User = null;

    this.http.get(this.usersUrl + '/' + id)
      .subscribe(data => {user = data.json() as User},
                       error => {this.handleError(error)});

    return user;
  }

  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error);
    return Promise.reject(error.message || error);
  }
}
