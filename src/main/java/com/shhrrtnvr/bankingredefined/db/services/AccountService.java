package com.shhrrtnvr.bankingredefined.db.services;

import com.shhrrtnvr.bankingredefined.db.entity.Account;
import com.shhrrtnvr.bankingredefined.utility.dto.model.AccountResponseDto;

public interface AccountService {
    Account createAccount(Account account);
    AccountResponseDto findByAccountId(Long accountId);
}
