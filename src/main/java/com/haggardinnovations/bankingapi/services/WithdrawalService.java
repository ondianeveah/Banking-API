package com.haggardinnovations.bankingapi.services;

import com.haggardinnovations.bankingapi.domains.Withdrawal;
import com.haggardinnovations.bankingapi.exceptions.ResourceNotFoundException;
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

    protected void verifyWithdrawal(Long withdrawalId) throws ResourceNotFoundException {
        Optional<Withdrawal> withdrawal = withdrawalRepo.findById(withdrawalId);
        if (withdrawal == null){
            throw new ResourceNotFoundException("Withdrawal with id" + withdrawalId + " not found");
        }
    }

    public Iterable<Withdrawal> getAllWithdrawals(Long id){
        List<Withdrawal> withdrawals = new ArrayList<>();
        withdrawalRepo.findAll().forEach(withdrawals::add);
        return withdrawals;
    }

    public Optional<Withdrawal> getWithdrawalById(Long withdrawalId){
        verifyWithdrawal(withdrawalId);
        return withdrawalRepo.findById(withdrawalId);
    }

    public void createWithdrawal(Withdrawal withdrawal){
        withdrawalRepo.save(withdrawal);
    }

    public void updateWithdrawal(Long withdrawalId, Withdrawal withdrawal){
        verifyWithdrawal(withdrawalId);
        withdrawalRepo.save(withdrawal);
    }

    public void deleteWithdrawal(Long withdrawalId){
        verifyWithdrawal(withdrawalId);
        withdrawalRepo.deleteById(withdrawalId);
    }
}
