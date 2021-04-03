package com.shhrrtnvr.bankingredefined.db.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity(name = "customer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {
    private static final String SEQ_CUSTOMER = "seq_customer_id";
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_CUSTOMER)
    @SequenceGenerator(name = SEQ_CUSTOMER, sequenceName = SEQ_CUSTOMER, allocationSize = 1)
    private long customerId;

    private String firstName;

    private String lastName;

    private String country;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private List<Account> accounts;

}
