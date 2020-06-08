package com.haggardinnovations.bankingapi.controllers;

import com.haggardinnovations.bankingapi.BankingApiApplication;
import com.haggardinnovations.bankingapi.domains.Customer;
import com.haggardinnovations.bankingapi.repositories.CustomerRepo;
import com.haggardinnovations.bankingapi.services.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {

    private static final Logger log = LoggerFactory.getLogger(BankingApiApplication.class);

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerRepo customerRepo;

    /*Starts with an endpoint and at this endpoint you're sending in a request to get something
    back and this case that something is a list of all customers, so you make a call to the service
    to be able to use the methods within that service, you then log an informative
     message that says (.....) and you're returning a list of all customers and whether or not
     the HTTP request has been successfully completed.*/
    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public ResponseEntity<List<Customer>> getAllCustomers(){
        List<Customer> customers = customerService.getAllCustomers();
        log.info("Get All Customers " + customers);
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @RequestMapping(value = "/customers/{id}", method = RequestMethod.GET)
    public ResponseEntity<Optional<Customer>> getCustomersById(@PathVariable Long id){
        Optional<Customer> customers = customerService.getCustomerById(id);
        log.info("Get Customers By Id " + customers);
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @RequestMapping(value = "/accounts/{accountId}/customer", method = RequestMethod.GET)
    public ResponseEntity<?> getCustomersAccountById(@PathVariable Long accountId){
        Customer customer = customerService.getCustomersByAccountId(accountId);
        log.info("Get Customers By Account Id " + customer);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @RequestMapping(value = "/customers", method = RequestMethod.POST)
    public ResponseEntity<?> createCustomer(@Valid @RequestBody Customer customer){
        Customer c = customerService.createCustomer(customer);
        HttpHeaders httpHeaders = new HttpHeaders();
        URI newCustomerUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(customer.getId())
                .toUri();
        httpHeaders.setLocation(newCustomerUri);
        log.info("Post New Customers " + c);
        return new ResponseEntity<>(null, httpHeaders, HttpStatus.CREATED);
    }


//
//    @RequestMapping(value = "/customers/{id}", method = RequestMethod.PUT)
//    public ResponseEntity<?> updateCustomerById(@PathVariable Long id, @RequestBody Customer customer){
//        customer.setId(id);
//        Customer c = customerService.updateCustomerById(id, customer);
//        log.info("Put Customers By Id " + c);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }


    @RequestMapping(value = "/customers/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteCustomerById(@PathVariable Long id){
        customerService.deleteCustomerById(id);
        log.info("Delete Customer By Id " + id );
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
