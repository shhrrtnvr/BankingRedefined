package com.shhrrtnvr.bankingredefined.db.services;

import com.shhrrtnvr.bankingredefined.db.entity.Customer;
import com.shhrrtnvr.bankingredefined.utility.dto.model.AccountResponseDto;
import com.shhrrtnvr.bankingredefined.utility.dto.model.CustomerDto;

public interface CustomerService {
    AccountResponseDto createCustomer(CustomerDto customerDto);

    Customer findByCustomerId(Long customerId);
}
