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

  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error);
    return Promise.reject(error.message || error);
  }
}
