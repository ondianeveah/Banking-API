package com.haggardinnovations.bankingapi.controllers;

import com.haggardinnovations.bankingapi.domains.Deposit;
import com.haggardinnovations.bankingapi.domains.Withdrawal;
import com.haggardinnovations.bankingapi.dto.SuccessfulResponseDetail;
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
        Iterable<Deposit> deposits = depositService.getAllDeposits(accountId);
        SuccessfulResponseDetail successfulResponseDetail = new SuccessfulResponseDetail(HttpStatus.OK.value(), "Success", deposits);
        return new ResponseEntity(successfulResponseDetail, HttpStatus.OK);
    }

    @RequestMapping(value = "/deposits/{depositId}", method = RequestMethod.GET)
    public ResponseEntity<?> getDepositById(@PathVariable Long depositId){
        Optional<Deposit> deposit = depositService.getDepositById(depositId);
        SuccessfulResponseDetail successfulResponseDetail = new SuccessfulResponseDetail(HttpStatus.OK.value(), "Success", deposit);
        return new ResponseEntity<>(successfulResponseDetail, HttpStatus.OK);
    }

    @RequestMapping(value = "/accounts/{accountId}/deposits", method = RequestMethod.POST)
    public ResponseEntity<?> createDeposit(@RequestBody Deposit deposit, @PathVariable Long accountId){
        depositService.createDeposit(deposit, accountId);
        HttpHeaders headers = new HttpHeaders();
        URI newWithdrawalUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/deposits")
                .buildAndExpand(deposit.getId())
                .toUri();
        headers.setLocation(newWithdrawalUri);
        SuccessfulResponseDetail successfulResponseDetail = new SuccessfulResponseDetail(HttpStatus.CREATED.value(), "Created deposit and added it to the account", deposit);
        return new ResponseEntity<>(successfulResponseDetail, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/deposits/{depositId}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateDeposit(@RequestBody Deposit deposit, @PathVariable Long depositId){
        depositService.updateDeposit(deposit, depositId);
        SuccessfulResponseDetail successfulResponseDetail = new SuccessfulResponseDetail(HttpStatus.ACCEPTED.value(), "Accepted deposit modification", deposit);
        return new ResponseEntity<>(deposit, HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/deposits/{depositId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteDeposit(@PathVariable Long depositId){
        depositService.deleteDeposit(depositId);
        SuccessfulResponseDetail successfulResponseDetail = new SuccessfulResponseDetail(HttpStatus.NO_CONTENT.value(), "Deleted Deposit", null);
        return new ResponseEntity<>(successfulResponseDetail, HttpStatus.NO_CONTENT);
    }
}
