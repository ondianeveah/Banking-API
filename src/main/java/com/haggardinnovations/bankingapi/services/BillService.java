package com.haggardinnovations.bankingapi.services;

import com.haggardinnovations.bankingapi.domains.Account;
import com.haggardinnovations.bankingapi.domains.Bill;
import com.haggardinnovations.bankingapi.exceptions.ResourceNotFoundException;
import com.haggardinnovations.bankingapi.repositories.AccountRepo;
import com.haggardinnovations.bankingapi.repositories.BillRepo;
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
    private AccountService accountService;

    public BillService(BillRepo billRepo) {
        this.billRepo = billRepo;
    }

    public List<Bill> getAllBillsByAccountId(Long accountId) {
        List<Bill> bills = (ArrayList<Bill>) billRepo.findAll();
//        verifyAccountById(accountId);
        List<Account> accounts = new ArrayList<>();
        for (Account account : accounts){
            if (account.getId().equals(accountId))
                return (List<Bill>) account;
        }
        return bills;
    }

    public Optional<Bill> getBillById(Long id){
        return billRepo.findById(id);
    }

//    public List<Bill> getBillsByCustomerId(Long customerId){
//        List<Account> accounts = accountService.getAllAccountsByCustomer(customerId);
//        List<Bill> listOfCustomers = new ArrayList<>();
//        for (Account account : accounts){
//            billRepo.findAll().forEach(listOfCustomers ::add);
//        }
//        return listOfCustomers;
//    }
    public Bill createBill(Bill bill){
        billRepo.save(bill);
        return bill;
    }
    public Bill updateBill(Long id, Bill bill){
        verifyBillById(id);
        billRepo.save(bill);
        return bill;
    }
    public Long deleteBill (Long billId){
        verifyBillById(billId);
        billRepo.deleteById(billId);
        return billId;
    }

    public void verifyBillById(Long billId) throws ResourceNotFoundException {
        Optional<Bill> bill = billRepo.findById(billId);
        if(!bill.isPresent()) {
            throw new ResourceNotFoundException("Bill with id " + billId + " not found");
        }
    }
//    public void verifyAccountById(Long accountId) throws ResourceNotFoundException {
//        Optional<Account> account = accountRepo.findById(accountId);
//        if(!account.isPresent()) {
//            throw new ResourceNotFoundException("Account with id " + accountId + " not found");
//        }
//    }


}
