package com.shhrrtnvr.bankingredefined.utility.dto.mapper;

import com.shhrrtnvr.bankingredefined.db.entity.Account;
import com.shhrrtnvr.bankingredefined.db.entity.Balance;
import com.shhrrtnvr.bankingredefined.utility.dto.model.BalanceDto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BalanceMapper {
    public static List<Balance> toBalanceListFromCurrencies(
            List<String> currencies,
            Account account
    ) {
        List<Balance> balances = new ArrayList<>();
        currencies.stream()
                .map(currency -> Balance.builder()
                        .account(account)
                        .currency(currency)
                        .balance(BigDecimal.ZERO)
                        .build()
                )
                .forEach(
                        balances::add
                );
        return balances;
    }

    public static BalanceDto toBalanceDto(Balance balance) {
        return BalanceDto.builder()
                .balance(balance.getBalance())
                .currency(balance.getCurrency())
                .build();
    }

    public static List<BalanceDto> toBalanceDtoList(List<Balance> balances) {
        return balances.stream()
                .map(BalanceMapper::toBalanceDto)
                .collect(Collectors.toList());
    }
}
