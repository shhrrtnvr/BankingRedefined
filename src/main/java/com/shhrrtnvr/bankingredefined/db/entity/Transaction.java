package com.shhrrtnvr.bankingredefined.db.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transaction {
    private static final String SEQ_TRANSACTION = "seq_transaction_id";
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_TRANSACTION)
    @SequenceGenerator(name = SEQ_TRANSACTION, sequenceName = SEQ_TRANSACTION, allocationSize = 1)
    private long transactionId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "account_id")
    private Account account;

    private BigDecimal amount;

    private String currency;

    private String direction;
}
