package com.haggardinnovations.bankingapi.domains;

import com.haggardinnovations.bankingapi.enumerations.AccountType;

import javax.persistence.*;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ACCOUNT_ID")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE")
    private AccountType type;

    @Column(name = "NICKNAME")
    private String nickname;

    @Column(name = "REWARDS")
    private Integer rewards;

    @Column(name = "BALANCE")
    private Double balance;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;

    public Account(){

    }

    public Account(Long id, AccountType type, String nickname, Integer rewards, Double balance, Customer customer) {
        this.id = id;
        this.type = type;
        this.nickname = nickname;
        this.rewards = rewards;
        this.balance = balance;
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getRewards() {
        return rewards;
    }

    public void setRewards(Integer rewards) {
        this.rewards = rewards;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", type=" + type +
                ", nickname='" + nickname + '\'' +
                ", rewards=" + rewards +
                ", balance=" + balance +
                ", customerId=" + customer +
                '}';
    }
}
