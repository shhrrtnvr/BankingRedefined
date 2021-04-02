package com.shhrrtnvr.bankingredefined.utility.dto.mapper;

import com.shhrrtnvr.bankingredefined.db.entity.Customer;
import com.shhrrtnvr.bankingredefined.utility.dto.model.CustomerDto;

public class CustomerMapper {
    public static Customer toCustomer(CustomerDto customerDto) {
        return Customer.builder()
                .customerId(customerDto.getCustomerId())
                .firstName(customerDto.getFirstname())
                .lastName(customerDto.getLastname())
                .country(customerDto.getCountry())
                .build();
    }

    public static CustomerDto toCustomerDto(Customer customer) {
        return CustomerDto.builder()
                .customerId(customer.getCustomerId())
                .firstname(customer.getFirstName())
                .lastname(customer.getLastName())
                .country(customer.getCountry())
                .build();
    }
}
