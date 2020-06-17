package com.haggardinnovations.bankingapi.repositories;


import com.haggardinnovations.bankingapi.domains.Deposit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepositRepo extends CrudRepository<Deposit, Long> {


}
