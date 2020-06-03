package com.haggardinnovations.bankingapi.controllers;


import com.haggardinnovations.bankingapi.domains.Account;
import com.haggardinnovations.bankingapi.domains.Withdrawal;
import com.haggardinnovations.bankingapi.repositories.WithdrawalRepo;
import com.haggardinnovations.bankingapi.services.WithdrawalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class WithdrawalController {

    @Autowired
    private WithdrawalRepo withdrawalRepo;

    @Autowired
    private WithdrawalService withdrawalService;

   // protected void verifyWithdrawal(Long withdrawalId) throws ResourceN

    @RequestMapping(value = "/accounts/{accountId}/withrdawals", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Withdrawal>> getAllWithdrawals(@PathVariable Long accountId){
        Iterable<Withdrawal> withdrawals = withdrawalRepo.findAll();
        return new ResponseEntity<>(withdrawals, HttpStatus.OK);
    }

    @RequestMapping(value = "/withdrawals/{withdrawalId}", method = RequestMethod.GET)
    public ResponseEntity<?> getWithdrawalById(@PathVariable Long withdrawalId){
        Optional<Withdrawal> withdrawal = withdrawalRepo.findById(withdrawalId);
        return new ResponseEntity<>(withdrawalId, HttpStatus.OK);
    }

    @RequestMapping(value = "/accounts/{accountId}/withdrawals", method = RequestMethod.POST)
    public ResponseEntity<?> createWithdrawal(@RequestBody Withdrawal withdrawal){
        withdrawal = withdrawalRepo.save(withdrawal);
        HttpHeaders headers = new HttpHeaders();
        URI newWithdrawalUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(withdrawal.getId())
                .toUri();
        headers.setLocation(newWithdrawalUri);
        return new ResponseEntity<>(null, headers, HttpStatus.CREATED);
    }

//    @RequestMapping(value = "/withdrawals/{withdrawalId}", method = RequestMethod.PUT)
//    public ResponseEntity<Object> updateWithdrawal(@RequestBody Withdrawal withdrawal, @PathVariable Long withdrawalId){
//
//    }









}
