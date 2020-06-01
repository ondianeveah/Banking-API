package com.haggardinnovations.bankingapi.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private enum type{
        SAVINGS {
            @Override
            public String toString() {
                return "Savings";
            }
        },
        CHECKING {
            @Override
            public String toString() {
                return "Checking";
            }
        },
        CREDIT {
            @Override
            public String toString() {
                return "Credit";
            }
        }
    };
    private String nickname;
    private Integer rewards;
    private Double balance;
    private Customer customer;

}
