package com.haggardinnovations.bankingapi.repositories;

import com.haggardinnovations.bankingapi.domains.Bill;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillRepo extends CrudRepository<Bill, Long> {
    List<Bill> findByAccountId(Long accountId);
}
