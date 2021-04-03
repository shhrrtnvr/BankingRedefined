package com.shhrrtnvr.bankingredefined.controller;

import com.shhrrtnvr.bankingredefined.db.services.TransactionService;
import com.shhrrtnvr.bankingredefined.utility.dto.model.TransactionDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;

    @PostMapping(value = "/transactions")
    public ResponseEntity<TransactionDto> createTransaction(@RequestBody TransactionDto transactionDto) {
        TransactionDto response = transactionService.createTransaction(transactionDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value = "/transactions/{account_id}")
    public ResponseEntity<List<TransactionDto>> getTransactions(@PathVariable Long account_id) {
        List<TransactionDto> transctions = transactionService.findByAccountId(account_id);
        return new ResponseEntity<>(transctions, HttpStatus.OK);
    }
}
