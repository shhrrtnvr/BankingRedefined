package com.shhrrtnvr.bankingredefined.db.repository;

import com.shhrrtnvr.bankingredefined.db.entity.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
    Account findByAccountId(Long accountId);
}
