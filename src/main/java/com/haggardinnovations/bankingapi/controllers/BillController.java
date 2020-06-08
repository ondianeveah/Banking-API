package com.haggardinnovations.bankingapi.controllers;

import com.haggardinnovations.bankingapi.domains.Bill;
import com.haggardinnovations.bankingapi.domains.Withdrawal;
import com.haggardinnovations.bankingapi.repositories.BillRepo;
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

    @Autowired
    private BillRepo billRepo;


    @RequestMapping(value = "/accounts/{accountId}/bills", method = RequestMethod.GET)
    public ResponseEntity<List<Bill>> getAllBillByAccount(@PathVariable Long id){
        List<Bill> bills = billService.getAllBillsByAccountId(id);
        return new ResponseEntity<>(bills, HttpStatus.OK);
    }

    @RequestMapping(value = " /bills/{billId}", method = RequestMethod.GET)
    public ResponseEntity<?> getBillById(@PathVariable Long id){
        Optional<Bill> bill = billService.getBillById(id);
        return new ResponseEntity<>(bill, HttpStatus.OK);
    }

//    @RequestMapping(value = " /customers/{customerId}/bills", method = RequestMethod.GET)
//    public ResponseEntity<List<Bill>> getBillsByCustomerId(@PathVariable Long id){
//        List<Bill> bills = billService.getBillsByCustomerId(id);
//        return new ResponseEntity<>(bills, HttpStatus.OK);
//    }

    @RequestMapping(value = "/accounts/{accountId}/bills", method = RequestMethod.POST)
    public ResponseEntity<?> createBill(@RequestBody Bill bill) {
        billService.createBill(bill);
        HttpHeaders headers = new HttpHeaders();
        URI newWithdrawalUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(bill.getId())
                .toUri();
        headers.setLocation(newWithdrawalUri);
        return new ResponseEntity<>(null, headers, HttpStatus.CREATED);


    }
    @RequestMapping(value = "/bills/{billId}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateBill(@PathVariable Long billId, @RequestBody Bill bill){
        billService.updateBill(billId, bill);
        return new ResponseEntity<>(bill, HttpStatus.OK);
    }

    @RequestMapping(value = "/bills/{billId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteBill(@PathVariable Long billId){
        billService.deleteBill(billId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
