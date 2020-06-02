package com.haggardinnovations.bankingapi.repository;

import com.haggardinnovations.bankingapi.domain.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepo extends CrudRepository<Customer, Long> {
}
