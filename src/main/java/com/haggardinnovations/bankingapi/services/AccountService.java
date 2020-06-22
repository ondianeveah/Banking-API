package com.haggardinnovations.bankingapi.services;

import com.haggardinnovations.bankingapi.domains.Account;
import com.haggardinnovations.bankingapi.domains.Customer;
import com.haggardinnovations.bankingapi.exceptions.ResourceNotFoundException;
import com.haggardinnovations.bankingapi.repositories.AccountRepo;
import com.haggardinnovations.bankingapi.repositories.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class AccountService {

    @Autowired
    private AccountRepo accountRepo;

    @Autowired
    private CustomerRepo customerRepo;

    public List<Account> getAllAccounts() {
        List<Account> listOfAccounts = new ArrayList<>();
        accountRepo.findAll().forEach(listOfAccounts::add);
        return listOfAccounts;
    }


    public Optional<Account> getAccountById(Long id) {
        verifyAccount(id);
        return accountRepo.findById(id);
    }

    // GOAL: Add an account by a customerId

    // Step 1: Loop through all the customers in the customerRepo
    // Step 1a: Check if the customer's id matches the passed customerId
    // Step 2: Set the account's customer object to the looped customer object
    // Step 3: Save the account to the accountRepo

    public void addAccount(Account account, Long customerId) {
        verifyCustomer(customerId);
        for (Customer customer : customerRepo.findAll()) {
            if (customer.getId().equals(customerId)) {
                account.setCustomer(customer);
                accountRepo.save(account);
            }
        }
    }

    public List<Account> getAllAccountsByCustomer(Long customerId) {
        verifyCustomer(customerId);
        List<Account> listOfCustomerAccounts = new ArrayList<>();
        accountRepo.findByCustomerId(customerId).forEach(listOfCustomerAccounts::add);
        return listOfCustomerAccounts;
    }

    // GOAL: Update the existing account by the accountId

    // Step 1: Loop through our customerRepo using a customer object as our iterator
    // Step 1a: Using the account object passed, we then set the customer as the iterator customer object
    // Step 2: Loop through our accountRepo using an account object as our iterator
    // Step 2a: Check if the account object's id is equal to the passed id
    // Step 3: Save the passed account object to the accountRepo

    public void updateAccount(Long accountId, Account account) {
        verifyAccount(accountId);
        for (Customer customer : customerRepo.findAll()) {
            account.setCustomer(customer);
            for (Account account1 : accountRepo.findAll()) {
                if (account1.getId().equals(accountId)) {
                    accountRepo.save(account);
                }
            }
        }
    }

    public void deleteAccountById(Long id) {
        verifyAccount(id);
        accountRepo.deleteById(id);
    }

    public void verifyAccount(Long accountId) throws ResourceNotFoundException {
        Optional<Account> account = accountRepo.findById(accountId);
        if (account.isEmpty()) {
            throw new ResourceNotFoundException("Account with id " + accountId + " not found");

        }
    }
    public void verifyCustomer(Long customerId) throws ResourceNotFoundException {
        Optional<Customer> customer = customerRepo.findById(customerId);
        if (customer.isEmpty()) {
            throw new ResourceNotFoundException("Account with customer id " + customerId + " not found");

        }
    }

}


