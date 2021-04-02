package com.shhrrtnvr.bankingredefined.db.repository;

import com.shhrrtnvr.bankingredefined.db.entity.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long> {
    List<Transaction> findByAccountId(Long accountId);
}
