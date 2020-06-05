package com.haggardinnovations.bankingapi.controllers;

import com.haggardinnovations.bankingapi.services.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillController {

    @Autowired
    private BillService billService;


}
