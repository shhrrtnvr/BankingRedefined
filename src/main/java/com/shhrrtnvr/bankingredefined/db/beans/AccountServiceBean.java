package com.shhrrtnvr.bankingredefined.db.beans;

import com.shhrrtnvr.bankingredefined.db.entity.Account;
import com.shhrrtnvr.bankingredefined.db.repository.AccountRepository;
import com.shhrrtnvr.bankingredefined.db.services.AccountService;
import com.shhrrtnvr.bankingredefined.utility.dto.mapper.BalanceMapper;
import com.shhrrtnvr.bankingredefined.utility.dto.model.AccountResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class AccountServiceBean implements AccountService {

    @Autowired
    private final AccountRepository accountRepository;

    @Override
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public AccountResponseDto findByAccountId(Long accountId) {
        Account account = accountRepository.findByAccountId(accountId);
        return AccountResponseDto.createAccountResponse(
                account.getAccountId(),
                account.getCustomer().getCustomerId(),
                account.getBalanceList().stream()
                    .map(BalanceMapper::toBalanceDto)
                    .collect(Collectors.toList())
        );
    }

}
