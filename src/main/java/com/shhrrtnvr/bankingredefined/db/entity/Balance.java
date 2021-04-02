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
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long balanceId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "accountId")
    private Account account;

    private String currency;

    private BigDecimal balance;

}
