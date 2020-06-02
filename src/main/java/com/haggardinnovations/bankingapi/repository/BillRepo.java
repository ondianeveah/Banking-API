package com.haggardinnovations.bankingapi.repository;

import com.haggardinnovations.bankingapi.domain.Bill;
import org.springframework.data.repository.CrudRepository;

public interface BillRepo extends CrudRepository<Bill, Long> {
}
