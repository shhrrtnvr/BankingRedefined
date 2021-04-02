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
public class AccountResponseDto {
    private long accountId;
    private long customerId;
    private List<BalanceDto> balances;

    public static AccountResponseDto createAccountResponse(
            long accountId,
            long customerId,
            List<BalanceDto> balances
    ) {
        return AccountResponseDto.builder()
                .accountId(accountId)
                .customerId(customerId)
                .balances(balances)
                .build();
    }
}
