package com.shhrrtnvr.bankingredefined.db.beans;

import com.shhrrtnvr.bankingredefined.db.entity.Account;
import com.shhrrtnvr.bankingredefined.db.entity.Balance;
import com.shhrrtnvr.bankingredefined.db.entity.Customer;
import com.shhrrtnvr.bankingredefined.db.repository.CustomerRepository;
import com.shhrrtnvr.bankingredefined.db.services.AccountService;
import com.shhrrtnvr.bankingredefined.db.services.BalanceService;
import com.shhrrtnvr.bankingredefined.db.services.CustomerService;
import com.shhrrtnvr.bankingredefined.utility.dto.mapper.AccountMapper;
import com.shhrrtnvr.bankingredefined.utility.dto.mapper.BalanceMapper;
import com.shhrrtnvr.bankingredefined.utility.dto.mapper.CustomerMapper;
import com.shhrrtnvr.bankingredefined.utility.dto.model.AccountResponseDto;
import com.shhrrtnvr.bankingredefined.utility.dto.model.CustomerDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class CustomerServiceBean implements CustomerService {
    private final CustomerRepository customerRepository;
    private final AccountService accountService;
    private final BalanceService balanceService;

    @Override
    public AccountResponseDto createCustomer(CustomerDto customerDto) {
        Customer customer = customerRepository.save(CustomerMapper.toCustomer(customerDto));
        Account account = accountService.createAccount(AccountMapper.toAccountFromCustomer(customer));
        List<Balance> balances = balanceService.saveBalance(
                BalanceMapper.toBalanceListFromCurrencies(
                        customerDto.getCurrencies(),
                        account
                )
        );

        return AccountResponseDto.createAccountResponse(
                account.getAccountId(),
                customer.getCustomerId(),
                BalanceMapper.toBalanceDtoList(balances)
        );
    }

    @Override
    public Customer findByCustomerId(Long customerId) {
        return customerRepository.findByCustomerId(customerId);
    }
}
