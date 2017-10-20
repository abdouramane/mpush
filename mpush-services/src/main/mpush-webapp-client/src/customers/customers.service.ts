import { Injectable } from '@angular/core';

import { Headers, Http } from '@angular/http';

import { Customer } from './customer'


@Injectable()

export class CustomersService {

  constructor(private http: Http) {

  }


  private customersUrl = '/mpush/api/customers';

  getAllCustomers(): Promise<Customer[]> {
    return this.http.get(this.customersUrl)
      .toPromise()
      .then(response => response.json() as Customer[])
      .catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error);
    return Promise.reject(error.message || error);
  }
}
