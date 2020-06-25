import { Component, OnInit } from '@angular/core';
import { CustomerDataService } from '../services/data/customer-data.service';
import { Router } from '@angular/router';

export class Customer {
  constructor(
    public id: number,
    public firstName: string,
    public lastName: string
  ) { }
}

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {

  customers: Customer[];

  constructor(
    private customerService: CustomerDataService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.refreshCustomers();
  }

  refreshCustomers() {
    this.customerService.retrieveAllCustomers().subscribe(
      response => {
        console.log(response);
        this.customers = response;
      }
    )
  }

}
