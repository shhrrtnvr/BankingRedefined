package com.shhrrtnvr.bankingredefined.db.repository;

import com.shhrrtnvr.bankingredefined.db.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    Customer findByCustomerId(Long customerId);
}
