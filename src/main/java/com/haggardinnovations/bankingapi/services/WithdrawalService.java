package com.haggardinnovations.bankingapi.services;

import com.haggardinnovations.bankingapi.domains.Account;
import com.haggardinnovations.bankingapi.domains.Customer;
import com.haggardinnovations.bankingapi.domains.Withdrawal;
import com.haggardinnovations.bankingapi.exceptions.ResourceNotFoundException;
import com.haggardinnovations.bankingapi.repositories.AccountRepo;
import com.haggardinnovations.bankingapi.repositories.WithdrawalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WithdrawalService {

    @Autowired
    private WithdrawalRepo withdrawalRepo;

    @Autowired
    private AccountRepo accountRepo;

    protected void verifyWithdrawal(Long withdrawalId) throws ResourceNotFoundException {
        Optional<Withdrawal> withdrawal = withdrawalRepo.findById(withdrawalId);
        if (withdrawal == null){
            throw new ResourceNotFoundException("Withdrawal with id" + withdrawalId + " not found");
        }
    }

    public List<Withdrawal> getAllWithdrawals(Long id){
        List<Withdrawal> withdrawals = new ArrayList<>();
        withdrawalRepo.findAll().forEach(withdrawals::add);
        return withdrawals;
    }

    public Optional<Withdrawal> getWithdrawalById(Long withdrawalId){
        verifyWithdrawal(withdrawalId);
        return withdrawalRepo.findById(withdrawalId);
    }

    // GOAL: Create a Withdrawal object by accountId

    // Step 1: Loop through all the accounts in the accountRepo
    // Step 1a: Check if the account's id matches the passed accountId
    // Step 2: Set the withdrawals's account object to the looped account object
    // Step 3: Save the withdrawal to the withdrawalRepo

    public void createWithdrawal(Withdrawal withdrawal, Long accountId){
        for (Account account : accountRepo.findAll()) {
            if (account.getId().equals(accountId)) {
                withdrawal.setAccount(account);
                withdrawalRepo.save(withdrawal);
            }
        }
    }

    public void updateWithdrawal(Long withdrawalId, Withdrawal withdrawal){
        for (Account account : accountRepo.findAll()) {
            withdrawal.setAccount(account);
            for (Withdrawal withdrawal1 : withdrawalRepo.findAll()){
                if (withdrawal1.getId().equals(withdrawalId)){
                    withdrawalRepo.save(withdrawal);
                }
            }
        }
    }

    public void deleteWithdrawal(Long withdrawalId){
        verifyWithdrawal(withdrawalId);
        withdrawalRepo.deleteById(withdrawalId);
    }
}
