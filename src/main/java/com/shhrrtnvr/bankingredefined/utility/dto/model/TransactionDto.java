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
public class TransactionDto {
    private Long transactionId;
    private Long accountId;
    private BigDecimal amount;
    private String currency;
    private String directionOfTransaction;
    private String description;
    private BigDecimal balanceAfterTransaction;
}