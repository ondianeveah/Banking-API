package com.haggardinnovations.bankingapi.controllers;



import com.haggardinnovations.bankingapi.domains.Withdrawal;

import com.haggardinnovations.bankingapi.services.WithdrawalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

import java.util.Optional;

@RestController
public class WithdrawalController {

    @Autowired
    private WithdrawalService withdrawalService;

    @RequestMapping(value = "/accounts/{accountId}/withdrawals", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Withdrawal>> getAllWithdrawals(@PathVariable Long accountId){
        Iterable<Withdrawal> withdrawals = withdrawalService.getAllWithdrawals(accountId);
        return new ResponseEntity<>(withdrawals, HttpStatus.OK);
    }

    @RequestMapping(value = "/withdrawals/{withdrawalId}", method = RequestMethod.GET)
    public ResponseEntity<?> getWithdrawalById(@PathVariable Long withdrawalId){
        Optional<Withdrawal> withdrawal = withdrawalService.getWithdrawalById(withdrawalId);
        return new ResponseEntity<>(withdrawal, HttpStatus.OK);
    }

    @RequestMapping(value = "/accounts/{accountId}/withdrawals", method = RequestMethod.POST)
    public ResponseEntity<?> createWithdrawal(@RequestBody Withdrawal withdrawal, @PathVariable Long accountId){
        withdrawalService.createWithdrawal(withdrawal, accountId);
        HttpHeaders headers = new HttpHeaders();
        URI newWithdrawalUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/withdrawals")
                .buildAndExpand(withdrawal.getId())
                .toUri();
        headers.setLocation(newWithdrawalUri);
        return new ResponseEntity<>(null, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/withdrawals/{withdrawalId}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateWithdrawal(@RequestBody Withdrawal withdrawal, @PathVariable Long withdrawalId){
        withdrawalService.updateWithdrawal(withdrawalId, withdrawal);
        return new ResponseEntity<>(withdrawal, HttpStatus.OK);
    }

    @RequestMapping(value = "/withdrawals/{withdrawalId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteWithdrawal(@PathVariable Long withdrawalId){
        withdrawalService.deleteWithdrawal(withdrawalId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}










