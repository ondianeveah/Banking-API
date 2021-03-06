package com.haggardinnovations.bankingapi.controllers;


import com.haggardinnovations.bankingapi.domains.Account;
import com.haggardinnovations.bankingapi.dto.SuccessfulResponseDetail;
import com.haggardinnovations.bankingapi.services.AccountService;
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
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/accounts", method = RequestMethod.GET)
    private ResponseEntity<List<Account>> getAllAccounts() {
        List<Account> accounts =  accountService.getAllAccounts();
        // Create a SuccessResponseDetail object
        // Pass in the status code, the string success, and all the accounts
        // Pass the resulting object in the ResponseEntity return
        SuccessfulResponseDetail successfulResponseDetail = new SuccessfulResponseDetail(HttpStatus.OK.value(), "Success", accounts);
        return new ResponseEntity(successfulResponseDetail, HttpStatus.OK);
    }

    @RequestMapping(value = "/customers/{customerId}/accounts", method = RequestMethod.POST)
    public ResponseEntity<?> addAccount(@Valid @RequestBody Account account, @PathVariable Long customerId) {
        accountService.addAccount(account, customerId);
        HttpHeaders httpHeaders = new HttpHeaders();
        URI newAccountUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/accounts")
                .buildAndExpand(account.getId())
                .toUri();
        httpHeaders.setLocation(newAccountUri);
        SuccessfulResponseDetail successfulResponseDetail = new SuccessfulResponseDetail(HttpStatus.CREATED.value(), "New account successfully created", account);
        return new ResponseEntity<>(successfulResponseDetail, httpHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/accounts/{accountId}", method = RequestMethod.GET)
    public ResponseEntity<?> getAccountById(@PathVariable Long accountId) {
        Optional<Account> id = accountService.getAccountById(accountId);
        SuccessfulResponseDetail successfulResponseDetail = new SuccessfulResponseDetail(HttpStatus.OK.value(), "success", id);
        return new ResponseEntity(successfulResponseDetail, HttpStatus.OK);
    }

    @RequestMapping(value = "/customers/{customerId}/accounts", method = RequestMethod.GET)
    private ResponseEntity<List<Account>> getAllAccountsForCustomer(@PathVariable Long customerId) {
        List<Account> cId = accountService.getAllAccountsByCustomer(customerId);
        SuccessfulResponseDetail successfulResponseDetail = new SuccessfulResponseDetail(HttpStatus.OK.value(), "success", cId);
        return new ResponseEntity(successfulResponseDetail, HttpStatus.OK);
    }


    @RequestMapping(value = "/accounts/{accountId}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateAccount(@PathVariable Long accountId, @RequestBody Account account) {
        accountService.updateAccount(accountId, account);
        SuccessfulResponseDetail successfulResponseDetail = new SuccessfulResponseDetail(HttpStatus.ACCEPTED.value(), "Customer account updated", account);
        return new ResponseEntity(successfulResponseDetail, HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/accounts/{accountId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteAccount(@PathVariable Long accountId) {
        accountService.deleteAccountById(accountId);
        SuccessfulResponseDetail successfulResponseDetail = new SuccessfulResponseDetail(HttpStatus.NO_CONTENT.value(), "Account successfully removed");
        return new ResponseEntity<>(successfulResponseDetail, HttpStatus.NO_CONTENT);
    }

}
