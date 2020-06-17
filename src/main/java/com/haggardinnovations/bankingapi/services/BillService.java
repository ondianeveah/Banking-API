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
//        verifyAccountById(accountId);
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

    // GOAL: Create a Bill object by accountId

    // Step 1: Loop through all the accounts in the accountRepo
    // Step 1a: Check if the account's id matches the passed accountId
    // Step 2: Set the bill's account object to the looped account object
    // Step 3: Save the bill to the billRepo

    public void createBill(Bill bill, Long accountId){
        for (Account account : accountRepo.findAll()) {
            if (account.getId().equals(accountId)) {
                bill.setAccount(account);
                billRepo.save(bill);
            }
        }
    }

    // GOAL: Update the bill by the bill id

    // Step 1: Looping through all the bills in the bill repo
    // Step 2: Checking if the id passed matches the current billId
    //

    public void updateBill(Long billId, Bill bill){
        for (Bill b : billRepo.findAll()) {
            if (b.getId().equals(billId)) {
                billRepo.save(bill);
            }
        }
    }
    public Long deleteBill (Long billId) {
        billRepo.deleteById(billId);
        return billId;
    }


}
