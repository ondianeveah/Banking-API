package com.haggardinnovations.bankingapi.services;

import com.haggardinnovations.bankingapi.domains.Account;
import com.haggardinnovations.bankingapi.domains.Customer;
import com.haggardinnovations.bankingapi.exceptions.ResourceNotFoundException;
import com.haggardinnovations.bankingapi.repositories.AccountRepo;
import com.haggardinnovations.bankingapi.repositories.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AccountService {

    @Autowired
    private AccountRepo accountRepo;

    @Autowired
    private CustomerRepo customerRepo;




    public Iterable<Account> getAllAccounts() {
        List<Account> listOfAccounts = new ArrayList<>();
        accountRepo.findAll().forEach(listOfAccounts::add);
        return listOfAccounts;
    }


    public Optional<Account> getAccountById(Long id) {
        verifyAccount(id);
        return accountRepo.findById(id);

    }

    public void addAccount(Account account) {
        accountRepo.save(account);

    }

    public List<Account> getAllAccountsByCustomer(Long customerId) {
        List<Account> listOfCustomerAccounts = new ArrayList<>();
//        verifyAccount(customer);
        accountRepo.findByCustomerId(customerId).forEach(listOfCustomerAccounts::add);
        return listOfCustomerAccounts;

    }

    public void updateAccount(Long id, Account account) {
        verifyAccount(id);
        accountRepo.save(account);

    }

//    public void deleteAccountById(Long id) {
//
//        verifyAccount(id);
//        Iterable<Customer> customer = customerRepo.findByAccount(id);
//        customerRepo.deleteAll(customer);
//        accountRepo.deleteById(id);
//
//    }
    public void verifyAccount(Long accountId) throws ResourceNotFoundException {

        Optional<Account> account = accountRepo.findById(accountId);
        if (!account.isPresent()) {
            throw new ResourceNotFoundException("Account with id " + accountId + " not found");

        }
    }
}

