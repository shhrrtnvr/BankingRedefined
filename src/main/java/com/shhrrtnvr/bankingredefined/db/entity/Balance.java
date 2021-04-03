package com.shhrrtnvr.bankingredefined.db.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name = "balance")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Balance {
    private static final String SEQ_BALANCE = "seq_balance_id";
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_BALANCE)
    @SequenceGenerator(name = SEQ_BALANCE, sequenceName = SEQ_BALANCE, allocationSize = 1)
    private long balanceId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "account_id")
    private Account account;

    private String currency;

    private BigDecimal balance;

}
