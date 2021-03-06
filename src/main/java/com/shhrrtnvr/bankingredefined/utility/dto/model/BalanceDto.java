package com.shhrrtnvr.bankingredefined.utility.dto.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BalanceDto {
    private BigDecimal balance;
    private String currency;
}
