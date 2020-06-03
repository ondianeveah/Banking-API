package com.haggardinnovations.bankingapi.repositories;


import com.haggardinnovations.bankingapi.domains.Deposit;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface DepositRepo extends CrudRepository<Deposit, Long> {
    List<Deposit> findByAccountId(Long accountId);
}
