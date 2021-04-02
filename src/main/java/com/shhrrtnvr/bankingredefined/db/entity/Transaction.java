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
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long transactionId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "accountId")
    private Account account;

    private BigDecimal amount;

    private String currency;

    private String direction;
}
