package com.shhrrtnvr.bankingredefined.utility.dto.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountDto {
    private long accountId;
    private long customerId;
}
