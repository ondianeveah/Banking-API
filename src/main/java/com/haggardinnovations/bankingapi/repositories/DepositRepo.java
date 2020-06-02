package com.haggardinnovations.bankingapi.repositories;


import com.haggardinnovations.bankingapi.domains.Deposit;
import org.springframework.data.repository.CrudRepository;

public interface DepositRepo extends CrudRepository<Deposit, Long> {
}
