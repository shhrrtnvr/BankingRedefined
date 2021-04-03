package com.shhrrtnvr.bankingredefined.controller;

import com.shhrrtnvr.bankingredefined.db.services.TransactionService;
import com.shhrrtnvr.bankingredefined.utility.dto.model.TransactionDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;

    @PostMapping(value = "/transactions")
    public ResponseEntity<TransactionDto> createTransaction(@RequestBody TransactionDto transactionDto) {
        TransactionDto response = transactionService.createTransaction(transactionDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
