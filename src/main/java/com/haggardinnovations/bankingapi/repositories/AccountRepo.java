package com.haggardinnovations.bankingapi.repositories;

import com.haggardinnovations.bankingapi.domains.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepo extends CrudRepository<Account, Long>{
    List<Account> findByCustomerId(Long customerId);
}

