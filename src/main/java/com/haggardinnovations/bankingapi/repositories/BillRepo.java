package com.haggardinnovations.bankingapi.repositories;

import com.haggardinnovations.bankingapi.domains.Bill;
import org.springframework.data.repository.CrudRepository;

public interface BillRepo extends CrudRepository<Bill, Long> {
}
