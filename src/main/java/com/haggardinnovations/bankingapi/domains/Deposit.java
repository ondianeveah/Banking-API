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

    @Column(name = "PAYER_ID")
    private Long payer_id;

    @Enumerated(EnumType.STRING)
    private TransactionMedium medium;

    @Column(name = "AMOUNT")
    private Double amount;

    @Column(name = "DESCRIPTION")
    private String description;

    public Deposit() {
    }

    public Deposit(@NotEmpty Long id, @NotEmpty TransactionType type, @NotEmpty String transactionDate, @NotEmpty TransactionStatus status, Long payer_id, TransactionMedium medium, @NotEmpty Double amount, String description) {
        this.id = id;
        this.type = type;
        this.transactionDate = transactionDate;
        this.status = status;
        this.payer_id = payer_id;
        this.medium = medium;
        this.amount = amount;
        this.description = description;
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

    public Long getPayer_id() {
        return payer_id;
    }

    public void setPayer_id(Long payer_id) {
        this.payer_id = payer_id;
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

    @Override
    public String toString() {
        return "Deposit{" +
                "id=" + id +
                ", type=" + type +
                ", transactionDate='" + transactionDate + '\'' +
                ", status=" + status +
                ", payer_id=" + payer_id +
                ", medium=" + medium +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                '}';
    }
}