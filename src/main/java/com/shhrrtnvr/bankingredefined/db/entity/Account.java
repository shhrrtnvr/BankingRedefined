package com.shhrrtnvr.bankingredefined.db.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity(name = "account")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Account {
    private static final String SEQ_ACCOUNT = "seq_account_id";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_ACCOUNT)
    @SequenceGenerator(name = SEQ_ACCOUNT, sequenceName = SEQ_ACCOUNT, allocationSize = 1)
    @Column(name = "account_id")
    private long accountId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
    private List<Balance> balanceList;
}
