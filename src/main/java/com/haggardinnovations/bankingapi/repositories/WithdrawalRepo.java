package com.haggardinnovations.bankingapi.repositories;

import com.haggardinnovations.bankingapi.domains.Withdrawal;
import org.springframework.data.repository.CrudRepository;

public interface WithdrawalRepo extends CrudRepository<Withdrawal, Long> {
}
