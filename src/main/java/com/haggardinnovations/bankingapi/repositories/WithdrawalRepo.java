package com.haggardinnovations.bankingapi.repositories;

import com.haggardinnovations.bankingapi.domains.Withdrawal;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WithdrawalRepo extends CrudRepository<Withdrawal, Long> {
}
