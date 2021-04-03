package com.shhrrtnvr.bankingredefined.controller;

import com.shhrrtnvr.bankingredefined.db.services.AccountService;
import com.shhrrtnvr.bankingredefined.db.services.CustomerService;
import com.shhrrtnvr.bankingredefined.utility.dto.model.AccountResponseDto;
import com.shhrrtnvr.bankingredefined.utility.dto.model.CustomerDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class AccountController {
    private final AccountService accountService;
    private final CustomerService customerService;

    @PostMapping(value = "/accounts")
    public ResponseEntity<AccountResponseDto> createAccount(@RequestBody CustomerDto customerDto) {
        AccountResponseDto responseDto = customerService.createCustomer(customerDto);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @GetMapping(value = "/accounts/{account_id}")
    public ResponseEntity<AccountResponseDto> getAccount(@PathVariable Long account_id) {
        AccountResponseDto responseDto = accountService.findByAccountId(account_id);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

}