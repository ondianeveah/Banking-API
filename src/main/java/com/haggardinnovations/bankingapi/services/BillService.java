package com.haggardinnovations.bankingapi.services;

import com.haggardinnovations.bankingapi.domains.Account;
import com.haggardinnovations.bankingapi.domains.Bill;
import com.haggardinnovations.bankingapi.exceptions.ResourceNotFoundException;
import com.haggardinnovations.bankingapi.repositories.AccountRepo;
import com.haggardinnovations.bankingapi.repositories.BillRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BillService {

    @Autowired
    private BillRepo billRepo;

    @Autowired
    private AccountRepo accountRepo;

    public List<Bill> getAllBillsByAccountId(Long accountId) {
        List<Bill> bills = (ArrayList<Bill>) billRepo.findAll();
        verifyAccountById(accountId);
        List<Account> accounts = new ArrayList<>();
        for (Account account : accounts){
            if (account.getId().equals(accountId))
                return (List<Bill>) account;
        }
        return bills;
    }

    public Optional<Bill> getBillById(Long id){
        return billRepo.findById(id);
    }

    // GOAL: Get the bills associated with the customer id

    // Step 1: Create an empty list of bills to hold bills that have been filtered by accountId
    // Step 2: Get all accounts by the customerId
    // Step 3: For each account loop through the list of accounts by customerId
    // Step 4: Retrieve all bills by the accountId
    // Step 4a: Add the bills by accountId to a list of bills
    // Step 5: Return the list of bills

    public List<Bill> getBillsByCustomerId(Long customerId) {
        List<Bill> billsByAccountId = new ArrayList<>();
        List<Account> accountsByCustomer = new ArrayList<>(accountRepo.findByCustomerId(customerId));

        for (Account account: accountsByCustomer) {
            billsByAccountId.addAll(billRepo.findByAccountId(account.getId()));
        }

        return billsByAccountId;
    }

    public Bill createBill(Bill bill){
        billRepo.save(bill);
        return bill;
    }
    public Bill updateBill(Long id, Bill bill){
        verifyBillById(id);
        billRepo.save(bill);
        return bill;
    }
    public Long deleteBill (Long billId){
        verifyBillById(billId);
        billRepo.deleteById(billId);
        return billId;
    }

    public void verifyBillById(Long billId) throws ResourceNotFoundException {
        Optional<Bill> bill = billRepo.findById(billId);
        if(!bill.isPresent()) {
            throw new ResourceNotFoundException("Bill with id " + billId + " not found");
        }
    }
    public void verifyAccountById(Long accountId) throws ResourceNotFoundException {
        Optional<Account> account = accountRepo.findById(accountId);
        if(!account.isPresent()) {
            throw new ResourceNotFoundException("Account with id " + accountId + " not found");
        }
    }
}
