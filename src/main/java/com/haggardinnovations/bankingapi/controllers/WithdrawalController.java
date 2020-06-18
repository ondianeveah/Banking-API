package com.haggardinnovations.bankingapi.controllers;



import com.haggardinnovations.bankingapi.domains.Withdrawal;

import com.haggardinnovations.bankingapi.dto.SuccessfulResponseDetail;
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
        // Create a SuccessResponseDetail object
        // Pass in the status code, the string success, and all the withdrawals
        // Pass the resulting object in the ResponseEntity return
        SuccessfulResponseDetail successfulResponseDetail = new SuccessfulResponseDetail(HttpStatus.OK.value(), "Success", withdrawals);
        return new ResponseEntity(successfulResponseDetail, HttpStatus.OK);
    }

    @RequestMapping(value = "/withdrawals/{withdrawalId}", method = RequestMethod.GET)
    public ResponseEntity<?> getWithdrawalById(@PathVariable Long withdrawalId){
        Optional<Withdrawal> withdrawal = withdrawalService.getWithdrawalById(withdrawalId);
        SuccessfulResponseDetail successfulResponseDetail = new SuccessfulResponseDetail(HttpStatus.OK.value(), "Success", withdrawal);
        return new ResponseEntity(successfulResponseDetail, HttpStatus.OK);
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
        SuccessfulResponseDetail successfulResponseDetail = new SuccessfulResponseDetail(HttpStatus.CREATED.value(), "Created withdrawal and deducted it from the account", withdrawal);
        return new ResponseEntity<>(successfulResponseDetail, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/withdrawals/{withdrawalId}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateWithdrawal(@RequestBody Withdrawal withdrawal, @PathVariable Long withdrawalId){
        withdrawalService.updateWithdrawal(withdrawalId, withdrawal);
        SuccessfulResponseDetail successfulResponseDetail = new SuccessfulResponseDetail(HttpStatus.ACCEPTED.value(), "Accepted withdrawal modification", withdrawal);
        return new ResponseEntity<>(successfulResponseDetail, HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/withdrawals/{withdrawalId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteWithdrawal(@PathVariable Long withdrawalId){
        withdrawalService.deleteWithdrawal(withdrawalId);
        SuccessfulResponseDetail successfulResponseDetail = new SuccessfulResponseDetail(HttpStatus.NO_CONTENT.value(), "Deleted Withdrawal", null);
        return new ResponseEntity<>(successfulResponseDetail, HttpStatus.NO_CONTENT);
    }
}










