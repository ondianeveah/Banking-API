package com.haggardinnovations.bankingapi.controllers;

import com.haggardinnovations.bankingapi.BankingApiApplication;
import com.haggardinnovations.bankingapi.domains.Customer;
import com.haggardinnovations.bankingapi.dto.SuccessfulResponseDetail;
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
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CustomerController {

    private static final Logger log = LoggerFactory.getLogger(BankingApiApplication.class);

    @Autowired
    private CustomerService customerService;


    /*Starts with an endpoint and at this endpoint you're sending in a request to get something
    back and this case that something is a list of all customers, so you make a call to the service
    to be able to use the methods within that service, you then log an informative
     message that says (.....) and you're returning a list of all customers and whether or not
     the HTTP request has been successfully completed.*/
    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Customer>> getAllCustomers(){
        Iterable<Customer> customers = customerService.getAllCustomers();
       // log.info("Get All Customers " + customers);
        SuccessfulResponseDetail successfulResponseDetail = new SuccessfulResponseDetail(HttpStatus.OK.value(), "Success", customers);
        return new ResponseEntity(successfulResponseDetail, HttpStatus.OK);
    }

    @RequestMapping(value = "/customers", method = RequestMethod.POST)
    public ResponseEntity<?> createCustomer(@Valid @RequestBody Customer customer){
        Customer c = customerService.createCustomer(customer);
        HttpHeaders httpHeaders = new HttpHeaders();
        URI newCustomerUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/customers")
                .buildAndExpand(customer.getId())
                .toUri();
        httpHeaders.setLocation(newCustomerUri);
      //  log.info("Post New Customers " + c);
        SuccessfulResponseDetail successfulResponseDetail = new SuccessfulResponseDetail(HttpStatus.CREATED.value(), "Customer Account Created!!", customer);
        return new ResponseEntity<>(successfulResponseDetail, httpHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/customers/{id}", method = RequestMethod.GET)
    public ResponseEntity<Optional<Customer>> getCustomersById(@PathVariable Long id){
        Optional<Customer> customers = customerService.getCustomerById(id);
     //   log.info("Get Customers By Id " + customers);
        SuccessfulResponseDetail successfulResponseDetail = new SuccessfulResponseDetail(HttpStatus.OK.value(), "Success", customers);
        return new ResponseEntity(successfulResponseDetail, HttpStatus.OK);
    }



    @RequestMapping(value = "/accounts/{accountId}/customer", method = RequestMethod.GET)
    public ResponseEntity<?> getCustomersByAccountId(@PathVariable Long accountId){
        Customer customer = customerService.getCustomersByAccountId(accountId);
      //  log.info("Get Customers By Account Id " + customer);
        SuccessfulResponseDetail successfulResponseDetail = new SuccessfulResponseDetail(HttpStatus.OK.value(), "Successly got customer's account by accountId", customer);
        return new ResponseEntity<>(successfulResponseDetail, HttpStatus.OK);
    }


    @RequestMapping(value = "/customers/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateCustomerById(@PathVariable Long id, @RequestBody Customer customer){
    //    customer.setId(id);
        customerService.updateCustomerById(id, customer);
      //  log.info("Put Customers By Id " + c);
        SuccessfulResponseDetail successfulResponseDetail = new SuccessfulResponseDetail(HttpStatus.ACCEPTED.value(), "Customer successfully updated by Id", customer);
        return new ResponseEntity(successfulResponseDetail, HttpStatus.ACCEPTED);
    }
}
