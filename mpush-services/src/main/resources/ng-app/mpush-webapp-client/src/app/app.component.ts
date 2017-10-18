import { Component } from '@angular/core';
import { CustomersService } from "../customers/customers.service";
import { Customer } from "../customers/customer";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app';
  customers: Customer[];

  constructor(private customersService: CustomersService) {

  }

  ngOnInit() {
    this.customersService.getAllCustomers().then(customers => this.customers = customers);
  }

}
