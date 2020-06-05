package com.haggardinnovations.bankingapi.repositories;


import com.haggardinnovations.bankingapi.domains.Deposit;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface DepositRepo extends CrudRepository<Deposit, Long> {
    //Failed to create query for method public abstract, No property accountId found for type Deposit
//    List<Deposit> findByAccountId(Long accountId);
}
