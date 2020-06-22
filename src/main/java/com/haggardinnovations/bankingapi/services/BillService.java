package com.haggardinnovations.bankingapi.services;

import com.haggardinnovations.bankingapi.domains.Account;
import com.haggardinnovations.bankingapi.domains.Bill;
import com.haggardinnovations.bankingapi.domains.Customer;
import com.haggardinnovations.bankingapi.exceptions.ResourceNotFoundException;
import com.haggardinnovations.bankingapi.repositories.AccountRepo;
import com.haggardinnovations.bankingapi.repositories.BillRepo;
import com.haggardinnovations.bankingapi.repositories.CustomerRepo;
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

    @Autowired
    private CustomerRepo customerRepo;

    public List<Bill> getAllBillsByAccountId(Long accountId) {
        List<Bill> bills = (ArrayList<Bill>) billRepo.findAll();
        verifyAccount(accountId);
        List<Account> accounts = new ArrayList<>();
        for (Account account : accounts) {
            if (account.getId().equals(accountId))
                return (List<Bill>) account;
        }
        return bills;
    }

    public Optional<Bill> getBillById(Long billId) {
        verifyBill(billId);
        return billRepo.findById(billId);
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
        verifyCustomer(customerId);

        for (Account account : accountsByCustomer) {
            billsByAccountId.addAll(billRepo.findByAccountId(account.getId()));
        }

        return billsByAccountId;
    }

    // GOAL: Create a Bill object by accountId

    // Step 1: Loop through all the accounts in the accountRepo
    // Step 1a: Check if the account's id matches the passed accountId
    // Step 2: Set the bill's account object to the looped account object
    // Step 3: Save the bill to the billRepo

    public void createBill(Bill bill, Long accountId) {
        verifyAccount(accountId);
        for (Account account : accountRepo.findAll()) {
            if (account.getId().equals(accountId)) {
                bill.setAccount(account);
                billRepo.save(bill);
            }
        }
    }

        // GOAL: Update the existing account by the accountId

        // Step 1: Loop through our customerRepo using a customer object as our iterator
        // Step 1a: Using the account object passed, we then set the customer as the iterator customer object
        // Step 2: Loop through our accountRepo using an account object as our iterator
        // Step 2a: Check if the account object's id is equal to the passed id
        // Step 3: Save the passed account object to the accountRepo


        public void updateBill (Long billId, Bill bill){
            for (Account a : accountRepo.findAll()) {
                bill.setAccount(a);
            }
            for (Bill b : billRepo.findAll()) {
                verifyBill(billId);
                if (b.getId().equals(billId)) {
                    billRepo.save(bill);
                }
            }
        }

        public Long deleteBill (Long billId){
            verifyBill(billId);
            billRepo.deleteById(billId);
            return billId;
        }

        public void verifyBill (Long billId) throws ResourceNotFoundException {
            Optional<Bill> bill = billRepo.findById(billId);
            if (!bill.isPresent()) {
                throw new ResourceNotFoundException("Bill with id " + billId + " not found");

            }
        }

        public void verifyCustomer (Long customerId) throws ResourceNotFoundException {
            Optional<Customer> customer = customerRepo.findById(customerId);
            if (customer.isEmpty()) {
                throw new ResourceNotFoundException("Customer with id " + customerId + " not found.");
            }
        }

        public void verifyAccount (Long accountId) throws ResourceNotFoundException {
            Optional<Account> account = accountRepo.findById(accountId);
            if (account.isEmpty()) {
                throw new ResourceNotFoundException("Account with id " + accountId + " not found.");
            }
        }


    }

