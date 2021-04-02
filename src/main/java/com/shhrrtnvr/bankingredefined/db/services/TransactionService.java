package com.shhrrtnvr.bankingredefined.db.services;

import com.shhrrtnvr.bankingredefined.utility.dto.model.TransactionDto;

import java.util.List;

public interface TransactionService {
    TransactionDto createTransaction(TransactionDto transactionDto);
    List<TransactionDto> findByAccountId(Long accountId);
}
