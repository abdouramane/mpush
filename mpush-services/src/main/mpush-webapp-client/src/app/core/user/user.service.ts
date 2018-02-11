import {Injectable} from '@angular/core';

import {Http} from '@angular/http';

import {User} from '../models/user.model'
import {Contact} from "../models/contact.model";


@Injectable()
export class UserService {

  constructor(private http: Http, public currentUser: User) {

  }


  private usersUrl = '/mpush/api/users';

  newContact(id : number, contact : Contact): Promise<User> {
    return this.http.post(this.usersUrl + "/" + id + "/contacts", contact)
        .toPromise()
        .then(response => response.json() as User)
        .catch(this.handleError);
  }

  deleteUserContacts(id: number, ids : number[]) {
    return this.http.patch(this.usersUrl + "/" + id + "/contacts", ids)
      .toPromise()
      .then(response => response.json())
      .catch(this.handleError);
  }

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
