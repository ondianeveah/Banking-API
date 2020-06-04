package com.haggardinnovations.bankingapi.repositories;

import com.haggardinnovations.bankingapi.domains.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepo extends CrudRepository<Account, Long> {
    Iterable<Account> findAll(Long customer);
}