package com.shhrrtnvr.bankingredefined.db.beans;

import com.shhrrtnvr.bankingredefined.db.entity.Account;
import com.shhrrtnvr.bankingredefined.db.entity.Balance;
import com.shhrrtnvr.bankingredefined.db.repository.AccountRepository;
import com.shhrrtnvr.bankingredefined.db.services.AccountService;
import com.shhrrtnvr.bankingredefined.db.services.BalanceService;
import com.shhrrtnvr.bankingredefined.utility.dto.mapper.BalanceMapper;
import com.shhrrtnvr.bankingredefined.utility.dto.model.AccountDto;
import com.shhrrtnvr.bankingredefined.utility.dto.model.AccountResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class AccountServiceBean implements AccountService {

    private final AccountRepository accountRepository;
    private final BalanceService balanceService;


    @Override
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public AccountResponseDto findByAccountId(Long accountId) {
        Account account = accountRepository.findByAccountId(accountId);
        List<Balance> balances = balanceService.findByAccountId(accountId);
        return AccountResponseDto.createAccountResponse(
                account.getAccountId(),
                account.getCustomer().getCustomerId(),
                BalanceMapper.toBalanceDtoList(balances)
        );
    }

}
