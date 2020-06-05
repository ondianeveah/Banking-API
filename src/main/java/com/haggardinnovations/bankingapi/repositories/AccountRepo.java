package com.haggardinnovations.bankingapi.repositories;

import com.haggardinnovations.bankingapi.domains.Account;
import com.haggardinnovations.bankingapi.domains.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccountRepo extends CrudRepository<Account, Long> {

    List<Account>findByCustomerId(Long customerId);

}

