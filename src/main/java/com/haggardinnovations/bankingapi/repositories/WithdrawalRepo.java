package com.haggardinnovations.bankingapi.repositories;

import com.haggardinnovations.bankingapi.domains.Withdrawal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WithdrawalRepo extends CrudRepository<Withdrawal, Long> {
}
