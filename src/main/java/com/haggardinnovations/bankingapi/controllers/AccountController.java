package com.haggardinnovations.bankingapi.controllers;


import com.haggardinnovations.bankingapi.domains.Account;
import com.haggardinnovations.bankingapi.repositories.AccountRepo;
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
    private AccountRepo accountRepo;

    @Autowired
    private AccountService accountService;


    @RequestMapping(value = "/accounts", method = RequestMethod.GET)
    private ResponseEntity<List<Account>> getAllAccounts() {
        List<Account> accounts =  accountService.getAllAccounts();
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @RequestMapping(value = "/customers/{customerId}/accounts", method = RequestMethod.POST)
    public ResponseEntity<?> addAccount(@Valid @RequestBody Account account) {
        accountService.addAccount(account);
        HttpHeaders httpHeaders = new HttpHeaders();
        URI newAccountUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(account.getId())
                .toUri();
        httpHeaders.setLocation(newAccountUri);
        return new ResponseEntity<>(null, httpHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/accounts/{accountId}", method = RequestMethod.GET)
    public ResponseEntity<?> getAccountById(@PathVariable Long customerId) {
        Optional<Account> id = accountService.getAccountById(customerId);

        return new ResponseEntity<>(id, HttpStatus.OK);

    }

//        @RequestMapping(value = "/customers/{customerId}/accounts", method = RequestMethod.GET)
//        private ResponseEntity<List<Account>> getAllAccountsForCustomer(@PathVariable Long customerId) {
//            List<Account> cId = accountService.getAllAccountsByCustomer(customerId);
//            return new ResponseEntity<>(cId, HttpStatus.OK);
//    }

    @RequestMapping(value = "/accounts/{accountId}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateAccount(@RequestBody Account account, @PathVariable Long id) {
        accountService.updateAccount(id, account);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    @RequestMapping(value = "/accounts/{accountId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteAccount(@PathVariable Long accountId) {
        accountService.deleteAccountById(accountId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
