package com.shhrrtnvr.bankingredefined.utility.dto.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDto {
    private Long customerId;
    private String firstname;
    private String lastname;
    private String country;
    private List<String> currencies;
}
