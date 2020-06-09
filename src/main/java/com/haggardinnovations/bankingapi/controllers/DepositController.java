package com.haggardinnovations.bankingapi.controllers;

import com.haggardinnovations.bankingapi.domains.Deposit;
import com.haggardinnovations.bankingapi.domains.Withdrawal;
import com.haggardinnovations.bankingapi.services.DepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
public class DepositController {

    @Autowired
    private DepositService depositService;

    @RequestMapping(value = "/accounts/{accountId}/deposits", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Deposit>> getAllDepositsByAccount(@PathVariable Long accountId){
        Iterable<Deposit> deposits = depositService.getAllDepositsByAccount(accountId);
        return new ResponseEntity<>(deposits, HttpStatus.OK);
    }

    @RequestMapping(value = "/deposits/{depositId}", method = RequestMethod.GET)
    public ResponseEntity<?> getDepositById(@PathVariable Long depositId){
        Optional<Deposit> deposit = depositService.getDepositById(depositId);
        return new ResponseEntity<>(deposit, HttpStatus.OK);
    }

    @RequestMapping(value = "/accounts/{accountId}/deposits", method = RequestMethod.POST)
    public ResponseEntity<?> createDeposit(@RequestBody Deposit deposit){
        depositService.createDeposit(deposit);
        HttpHeaders headers = new HttpHeaders();
        URI newWithdrawalUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(deposit.getId())
                .toUri();
        headers.setLocation(newWithdrawalUri);
        return new ResponseEntity<>(null, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/deposits/{depositId}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateDeposit(@RequestBody Deposit deposit, @PathVariable Long depositId){
        depositService.updateDeposit(deposit, depositId);
        return new ResponseEntity<>(deposit, HttpStatus.OK);
    }

    @RequestMapping(value = "/deposits/{depositId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteDeposit(@PathVariable Long depositId){
        depositService.deleteDeposit(depositId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
