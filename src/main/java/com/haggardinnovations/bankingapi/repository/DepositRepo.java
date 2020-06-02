package com.haggardinnovations.bankingapi.repository;


import com.haggardinnovations.bankingapi.domain.Deposit;
import org.springframework.data.repository.CrudRepository;

public interface DepositRepo extends CrudRepository<Deposit, Long> {
}
