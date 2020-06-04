package com.haggardinnovations.bankingapi.domains;

import com.haggardinnovations.bankingapi.enumerations.TransactionMedium;
import com.haggardinnovations.bankingapi.enumerations.TransactionStatus;
import com.haggardinnovations.bankingapi.enumerations.TransactionType;

import javax.persistence.*;

@Entity
public class Withdrawal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "WITHDRAWAL_ID")
    private Long id;

    @Enumerated(EnumType.STRING)
    private TransactionType type;

    @Column(name = "TRANSACTION_DATE")
    private String transaction_date;

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

    public Withdrawal() {
    }

    public Withdrawal(Long id, TransactionType type, String transaction_date, TransactionStatus status, Long payer_id, TransactionMedium medium, Double amount, String description) {
        this.id = id;
        this.type = type;
        this.transaction_date = transaction_date;
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

    public String getTransaction_date() {
        return transaction_date;
    }

    public void setTransaction_date(String transaction_date) {
        this.transaction_date = transaction_date;
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
        return "Withdrawal{" +
                "id=" + id +
                ", type=" + type +
                ", transaction_date='" + transaction_date + '\'' +
                ", status=" + status +
                ", payer_id=" + payer_id +
                ", medium=" + medium +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                '}';
    }
}
