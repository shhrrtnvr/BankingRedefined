package com.shhrrtnvr.bankingredefined.utility.dto.mapper;

import com.shhrrtnvr.bankingredefined.db.entity.Account;
import com.shhrrtnvr.bankingredefined.db.entity.Customer;
import com.shhrrtnvr.bankingredefined.utility.dto.model.AccountDto;

public class AccountMapper {
    public static Account toAccountFromCustomer(Customer customer) {
        return Account.builder()
                .customer(customer)
                .build();
    }

    public static AccountDto toAccountDto(Account account, Long customerId) {
        return AccountDto.builder()
                .accountId(account.getAccountId())
                .customerId(customerId)
                .build();
    }
    public static Account toAccount(AccountDto accountDto) {
        return Account.builder()
                .accountId(accountDto.getAccountId())
                .build();
    }
}
