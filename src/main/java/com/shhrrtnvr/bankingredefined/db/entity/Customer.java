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
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long customerId;

    private String firstName;

    private String lastName;

    private String country;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private List<Account> accounts;

}
