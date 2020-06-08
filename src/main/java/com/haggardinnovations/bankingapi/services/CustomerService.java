package com.haggardinnovations.bankingapi.services;


import com.haggardinnovations.bankingapi.domains.Account;
import com.haggardinnovations.bankingapi.domains.Customer;
import com.haggardinnovations.bankingapi.exceptions.ResourceNotFoundException;
import com.haggardinnovations.bankingapi.repositories.AccountRepo;
import com.haggardinnovations.bankingapi.repositories.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private AccountRepo accountRepo;

    public void verifyCustomer(Long id) throws ResourceNotFoundException {
        Optional<Customer> customer = customerRepo.findById(id);
        if (customer.isEmpty()) {
            throw new ResourceNotFoundException("Customer with id " + id + " not found.");
        }
    }

    public void verifyAccount(Long id) throws ResourceNotFoundException {
        Optional<Account> account = accountRepo.findById(id);
        if (account.isEmpty()) {
            throw new ResourceNotFoundException("Account with id " + id + " not found.");
        }
    }

    public Iterable<Customer> getAllCustomers() {
      //  List<Customer> listOfCustomers = new ArrayList<>();
        return customerRepo.findAll();
                //.forEach(listOfCustomers::add);
      //  return listOfCustomers;
    }

    public Optional<Customer> getCustomerById(Long id) {
        verifyCustomer(id);
        return customerRepo.findById(id);
    }

    public Customer createCustomer(Customer customer) {
        return customerRepo.save(customer);
    }

    public Customer getCustomersByAccountId(Long accountId) throws ResourceNotFoundException {
        //  verifyAccount(accountId);
        Customer customer;
        for (Account account : accountRepo.findAll()) {
            if (account.getId().equals(accountId)) {
                customer = account.getCustomer();
                return customer;
            }
        }
        throw new ResourceNotFoundException();
    }


    public void deleteCustomerById(Long id) {
        customerRepo.deleteById(id);
    }


    public void updateCustomerById(Long customerId, Customer customer){
        verifyCustomer(customer.getId());
        for(Customer c : customerRepo.findAll()){
            if(c.getId().equals(customerId)){
                customerRepo.save(customer);
            }
        }
    }
}
