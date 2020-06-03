package com.haggardinnovations.bankingapi.services;

import com.haggardinnovations.bankingapi.repositories.WithdrawalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WithdrawalService {

    @Autowired
    private WithdrawalRepo withdrawalRepo;


}
