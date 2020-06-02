package com.haggardinnovations.bankingapi.repository;

import com.haggardinnovations.bankingapi.domain.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepo extends CrudRepository<Account, Long> {
}
