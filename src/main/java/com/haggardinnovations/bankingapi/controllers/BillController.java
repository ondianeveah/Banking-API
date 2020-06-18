package com.haggardinnovations.bankingapi.controllers;

import com.haggardinnovations.bankingapi.domains.Bill;

import com.haggardinnovations.bankingapi.services.BillService;
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
public class BillController {

    @Autowired
    private BillService billService;



    @RequestMapping(value = "/accounts/{accountId}/bills", method = RequestMethod.GET)
    public ResponseEntity<List<Bill>> getAllBillByAccount(@PathVariable Long accountId){
        List<Bill> bills = billService.getAllBillsByAccountId(accountId);
        return new ResponseEntity<>(bills, HttpStatus.OK);
    }

    @RequestMapping(value = " /bills/{billId}", method = RequestMethod.GET)
    public ResponseEntity<?> getBillById(@PathVariable Long billId){
        Optional<Bill> bill = billService.getBillById(billId);
        return new ResponseEntity<>(bill, HttpStatus.OK);
    }


    @RequestMapping(value = " /customers/{customerId}/bills", method = RequestMethod.GET)
    public ResponseEntity<List<Bill>> getBillsByCustomerId(@PathVariable Long customerId){
        List<Bill> bills = billService.getBillsByCustomerId(customerId);
        return new ResponseEntity<>(bills, HttpStatus.OK);
    }

    @RequestMapping(value = "/accounts/{accountId}/bills", method = RequestMethod.POST)
    public ResponseEntity<?> createBill(@RequestBody Bill bill, @PathVariable Long accountId) {
        billService.createBill(bill, accountId);
        HttpHeaders headers = new HttpHeaders();
        URI newWithdrawalUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/bills")
                .buildAndExpand(bill.getId())
                .toUri();
        headers.setLocation(newWithdrawalUri);
        return new ResponseEntity<>(null, headers, HttpStatus.CREATED);


    }
    @RequestMapping(value = "/bills/{billId}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateBill(@PathVariable Long billId, @RequestBody Bill bill){
        billService.updateBill(billId, bill);
        return new ResponseEntity<>(bill, HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/bills/{billId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteBill(@PathVariable Long billId){
        billService.deleteBill(billId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
