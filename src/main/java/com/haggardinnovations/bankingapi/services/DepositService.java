package com.haggardinnovations.bankingapi.services;

import com.haggardinnovations.bankingapi.domains.Account;
import com.haggardinnovations.bankingapi.domains.Deposit;
import com.haggardinnovations.bankingapi.domains.Withdrawal;
import com.haggardinnovations.bankingapi.exceptions.ResourceNotFoundException;
import com.haggardinnovations.bankingapi.repositories.AccountRepo;
import com.haggardinnovations.bankingapi.repositories.DepositRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DepositService {

    @Autowired
    private DepositRepo depositRepo;

    @Autowired
    private AccountRepo accountRepo;

    protected void verifyDeposit(Long depositId) throws ResourceNotFoundException {
        Optional<Deposit> deposit = depositRepo.findById(depositId);
        if (deposit.isEmpty()){
            throw new ResourceNotFoundException("Deposit with id " + depositId + " not found");
        }
    }

    public List<Deposit> getAllDeposits(Long id){
        List<Deposit> deposits = new ArrayList<>();
        depositRepo.findAll().forEach(deposits::add);
        return deposits;
    }

    public Optional<Deposit> getDepositById(Long depositId){
        verifyDeposit(depositId);
        return depositRepo.findById(depositId);
    }

    public void createDeposit(Deposit deposit, Long accountId) {
        for (Account account : accountRepo.findAll()) {
            if (account.getId().equals(accountId)) {
                deposit.setAccount(account);
                depositRepo.save(deposit);
            }
        }
    }

    public void updateDeposit(Deposit deposit, Long id){
        verifyDeposit(id);
        for (Account account : accountRepo.findAll()) {
            deposit.setAccount(account);
            for (Deposit deposit1 : depositRepo.findAll()){
                if (deposit1.getId().equals(id)){
                    depositRepo.save(deposit);
                }
            }
        }
    }

    public void deleteDeposit(Long id){
        verifyDeposit(id);
        depositRepo.deleteById(id);
    }

}
