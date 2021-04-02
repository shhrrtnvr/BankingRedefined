package com.shhrrtnvr.bankingredefined.db.repository;

import com.shhrrtnvr.bankingredefined.db.entity.Balance;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BalanceRepository extends CrudRepository<Balance, Long> {
    Balance findByAccountAccountIdAndCurrency(Long accountId, String currency);
}
