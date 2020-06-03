package com.haggardinnovations.bankingapi.controllers;


import com.haggardinnovations.bankingapi.repositories.WithdrawalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WithdrawalController {

    @Autowired
    private WithdrawalRepo withdrawalRepo;



}
