package com.haggardinnovations.bankingapi.services;


import com.haggardinnovations.bankingapi.domains.Account;
import com.haggardinnovations.bankingapi.domains.Customer;
import com.haggardinnovations.bankingapi.exceptions.ResourceNotFoundException;
import com.haggardinnovations.bankingapi.repositories.AccountRepo;
import com.haggardinnovations.bankingapi.repositories.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    public void verifyCustomer(Long id) throws ResourceNotFoundException{
        Optional<Customer> customer = customerRepo.findById(id);
        if(customer.isEmpty()){
            throw new ResourceNotFoundException("Customer with id " + id + " not found.");
        }
    }

    public void verifyAccount(Long id) throws ResourceNotFoundException{
        Optional<Account> account = accountRepo.findById(id);
        if(account.isEmpty()){
            throw new ResourceNotFoundException("Account with id " + id + " not found.");
        }
    }

    public List<Customer> getAllCustomers(){
        List<Customer> listOfCustomers = new ArrayList<>();
        customerRepo.findAll().forEach(listOfCustomers::add);
        return listOfCustomers;
    }

    public Optional<Customer> getCustomerById(Long id) {
        verifyCustomer(id);
       Optional<Customer> customer = customerRepo.findById(id);
       return customer;
    }

    public void createCustomer(Customer customer){
         customerRepo.save(customer);
    }

    public Customer getCustomerByAccountId(Long id) throws ResourceNotFoundException{
        verifyAccount(id);
        List<Account> accounts = new ArrayList<>();
        for(Account account : accounts){
            if(account.getId().equals(id)){
                return account.getCustomer();
            }
        }
        throw  new ResourceNotFoundException();
    }

    public void deleteCustomerById(Long id){
        customerRepo.deleteById(id);
    }

    public void updateCustomerById(Long id, Customer customer){
        verifyCustomer(id);
        customerRepo.save(customer);
    }
}
