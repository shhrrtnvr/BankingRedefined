package com.shhrrtnvr.bankingredefined.utility.dto.mapper;

import com.shhrrtnvr.bankingredefined.db.entity.Balance;
import com.shhrrtnvr.bankingredefined.db.entity.Transaction;
import com.shhrrtnvr.bankingredefined.utility.dto.model.TransactionDto;

public class TransactionMapper {
    public static Transaction toTransaction(TransactionDto transactionDto, Balance balance) {
        return Transaction.builder()
                .account(balance.getAccount())
                .amount(transactionDto.getAmount())
                .currency(balance.getCurrency())
                .direction(transactionDto.getDirectionOfTransaction())
                .build();
    }

    public static TransactionDto toTransactionDto(Transaction transaction) {
        return TransactionDto.builder()
                .transactionId(transaction.getTransactionId())
                .accountId(transaction.getAccount().getAccountId())
                .amount(transaction.getAmount())
                .currency(transaction.getCurrency())
                .directionOfTransaction(transaction.getDirection())
                .build();
    }
}
