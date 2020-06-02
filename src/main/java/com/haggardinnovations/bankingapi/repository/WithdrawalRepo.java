package com.haggardinnovations.bankingapi.repository;

import com.haggardinnovations.bankingapi.domain.Withdrawal;
import org.springframework.data.repository.CrudRepository;

public interface WithdrawalRepo extends CrudRepository<Withdrawal, Long> {
}
