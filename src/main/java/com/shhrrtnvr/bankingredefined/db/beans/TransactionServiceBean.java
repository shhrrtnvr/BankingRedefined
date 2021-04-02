package com.shhrrtnvr.bankingredefined.db.beans;

import com.shhrrtnvr.bankingredefined.db.entity.Balance;
import com.shhrrtnvr.bankingredefined.db.entity.Transaction;
import com.shhrrtnvr.bankingredefined.db.repository.AccountRepository;
import com.shhrrtnvr.bankingredefined.db.repository.TransactionRepository;
import com.shhrrtnvr.bankingredefined.db.services.BalanceService;
import com.shhrrtnvr.bankingredefined.db.services.TransactionService;
import com.shhrrtnvr.bankingredefined.utility.dto.mapper.TransactionMapper;
import com.shhrrtnvr.bankingredefined.utility.dto.model.TransactionDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TransactionServiceBean implements TransactionService {
    private final TransactionRepository transactionRepository;
    private final BalanceService balanceService;
    private final AccountRepository accountRepository;


    @Override
    @Transactional
    public TransactionDto createTransaction(TransactionDto transactionDto) {
        Balance balance = balanceService.findByAccountIdAndCurrency(
                transactionDto.getAccountId(),
                transactionDto.getCurrency()
        );
        balance.setAccount(
                accountRepository.findByAccountId(transactionDto.getAccountId())
        );
        if (transactionDto.getDirectionOfTransaction().equals("IN")) {
            balance.setBalance(balance.getBalance().add(transactionDto.getAmount()));
        }
        else if (transactionDto.getDirectionOfTransaction().equals("OUT")) {
            if (balance.getBalance().compareTo(transactionDto.getAmount()) != -1) {
                balance.setBalance(balance.getBalance().subtract(transactionDto.getAmount()));
            }
        }
        balanceService.saveBalance(balance);

        Transaction savedTransaction = transactionRepository.save(
                TransactionMapper.toTransaction(transactionDto, balance)
        );

        return TransactionMapper.toTransactionDto(savedTransaction);
    }

    @Override
    public List<TransactionDto> findByAccountId(Long accountId) {
        return transactionRepository.findByAccountAccountId(accountId)
                .stream()
                .map(TransactionMapper::toTransactionDto)
                .collect(Collectors.toList());
    }
}
