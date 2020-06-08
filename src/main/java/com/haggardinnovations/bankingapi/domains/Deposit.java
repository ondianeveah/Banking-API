package com.haggardinnovations.bankingapi.domains;

import com.haggardinnovations.bankingapi.enumerations.TransactionMedium;
import com.haggardinnovations.bankingapi.enumerations.TransactionStatus;
import com.haggardinnovations.bankingapi.enumerations.TransactionType;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
public class Deposit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DEPOSIT_ID")
    private Long id;

    @Enumerated(EnumType.STRING)
    private TransactionType type;

    @Column(name = "TRANSACTION_DATE")
    private String transactionDate;

    @Enumerated(EnumType.STRING)
    private TransactionStatus status;

    @Column(name = "PAYEE_ID")
    private Long payee_id;

    @Enumerated(EnumType.STRING)
    private TransactionMedium medium;

    @Column(name = "AMOUNT")
    private Double amount;

    @Column(name = "DESCRIPTION")
    private String description;

    @ManyToOne
    @JoinColumn(name = "ACCOUNT_ID")
    private Account account;

    public Deposit() {
    }

    public Deposit(Long id, TransactionType type, String transactionDate, TransactionStatus status, Long payee_id, TransactionMedium medium, Double amount, String description, Account account) {
        this.id = id;
        this.type = type;
        this.transactionDate = transactionDate;
        this.status = status;
        this.payee_id = payee_id;
        this.medium = medium;
        this.amount = amount;
        this.description = description;
        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
    }


    public Long getPayee_id() {
        return payee_id;
    }

    public void setPayee_id(Long payee_id) {
        this.payee_id = payee_id;
    }

    public TransactionMedium getMedium() {
        return medium;
    }

    public void setMedium(TransactionMedium medium) {
        this.medium = medium;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Deposit{" +
                "id=" + id +
                ", type=" + type +
                ", transactionDate='" + transactionDate + '\'' +
                ", status=" + status +
                ", payee_id=" + payee_id +
                ", medium=" + medium +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", account=" + account +
                '}';
    }
}