package com.haggardinnovations.bankingapi.repositories;

import com.haggardinnovations.bankingapi.domains.Bill;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BillRepo extends CrudRepository<Bill, Long> {
    List<Bill> findByCustomerId(Long customerId);
}
