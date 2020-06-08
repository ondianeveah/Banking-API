package com.haggardinnovations.bankingapi.services;

import com.haggardinnovations.bankingapi.domains.Deposit;
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
    //Fix what is commented out. Look at previous APIs(quick-poll specifically)

//    public List<Deposit> getAllDepositsByAccount(Long accountId){
//        List<Deposit> depositList = new ArrayList<>();
//        depositRepo.findByAccountId(accountId).forEach(depositList::add);
//        return depositList;
//    }
    public Optional<Deposit> getOneDepositById(Long accountId){
        return depositRepo.findById(accountId);
    }
    public void createDeposit(Deposit deposit, Long accountId){
        depositRepo.save(deposit);
    }
    public void updateDeposit(Deposit deposit, Long depositId){
        depositRepo.save(deposit);
    }
    public void deleteDeposit(Long id){
        depositRepo.deleteById(id);
    }
}
