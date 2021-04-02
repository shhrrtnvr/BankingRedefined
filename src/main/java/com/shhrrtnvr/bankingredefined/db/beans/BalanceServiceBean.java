package com.shhrrtnvr.bankingredefined.db.beans;

import com.shhrrtnvr.bankingredefined.db.entity.Balance;
import com.shhrrtnvr.bankingredefined.db.repository.BalanceRepository;
import com.shhrrtnvr.bankingredefined.db.services.BalanceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@AllArgsConstructor
public class BalanceServiceBean implements BalanceService {
    private final BalanceRepository balanceRepository;

    @Override
    public Balance saveBalance(Balance balance) {
        return balanceRepository.save(balance);
    }

    @Override
    public List<Balance> saveBalance(List<Balance> balances) {
        return StreamSupport.stream(
                balanceRepository.saveAll(balances).spliterator(),
                false
        ).collect(Collectors.toList());
    }

    @Override
    public List<Balance> findByAccountId(Long accountId) {
        return balanceRepository.findByAccountId(accountId);
    }

    @Override
    public Balance findByAccountIdAndCurrency(Long accountId, String currency) {
        return balanceRepository.findByAccountIdAndCurrency(accountId, currency);
    }
}
