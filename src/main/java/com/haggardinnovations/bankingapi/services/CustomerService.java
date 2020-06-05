package com.haggardinnovations.bankingapi.services;


import com.haggardinnovations.bankingapi.domains.Customer;
import com.haggardinnovations.bankingapi.repositories.AccountRepo;
import com.haggardinnovations.bankingapi.repositories.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private AccountRepo accountRepo;

    public Iterable<Customer> getAllCustomers(){
        List<Customer> customerList = new ArrayList<>();
        customerRepo.findAll().forEach(customerList::add);
        return customerList;
    }
    public Optional<Customer> getCustomerById(Long id) {
       Optional<Customer> c = customerRepo.findById(id);
       return c;
    }


}
