import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { Router } from '@angular/router';
import {UserService} from "../../../users/users.service";
import { Observable } from 'rxjs/Rx';

@Injectable()
export class RegistrationService {

private registerUrl = '/mpush/api/users';

constructor(private http: Http, private router: Router, private userService: UserService) { }

 save(user: any): Observable<any> {
        return this.http.put(this.registerUrl, user);
    }

}
