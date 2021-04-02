package com.shhrrtnvr.bankingredefined.db.beans;

import com.shhrrtnvr.bankingredefined.db.entity.Account;
import com.shhrrtnvr.bankingredefined.db.repository.AccountRepository;
import com.shhrrtnvr.bankingredefined.db.services.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AccountServiceBean implements AccountService {

    private final AccountRepository accountRepository;

    @Override
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

}
