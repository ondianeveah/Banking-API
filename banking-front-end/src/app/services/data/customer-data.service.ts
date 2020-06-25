import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Customer } from 'src/app/customer/customer.component';
import { API_URL } from 'src/app/app.constants';

@Injectable({
  providedIn: 'root'
})
export class CustomerDataService {

  constructor(private http: HttpClient) { }

  retrieveAllCustomers() {
    return this.http.get<Customer[]>(`${API_URL}/customers`);
  }

}
