package com.shhrrtnvr.bankingredefined.db.services;

import com.shhrrtnvr.bankingredefined.db.entity.Balance;

import java.util.List;

public interface BalanceService {
    Balance saveBalance(Balance balance);
    List<Balance> saveBalance(List<Balance> balances);
    Balance findByAccountIdAndCurrency(Long accountId, String currency);
}
