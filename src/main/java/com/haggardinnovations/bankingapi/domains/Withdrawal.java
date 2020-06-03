package com.haggardinnovations.bankingapi.domains;

import com.haggardinnovations.bankingapi.enumerations.WithdrawalMedium;
import com.haggardinnovations.bankingapi.enumerations.WithdrawalStatus;
import com.haggardinnovations.bankingapi.enumerations.WithdrawalType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Withdrawal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private WithdrawalType type;
    private String transaction_date;
    private WithdrawalStatus status;
    private Long payer_id;
    private WithdrawalMedium medium;
    private Double amount;
    private String description;

    public Withdrawal() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public WithdrawalType getType() {
        return type;
    }

    public void setType(WithdrawalType type) {
        this.type = type;
    }

    public String getTransaction_date() {
        return transaction_date;
    }

    public void setTransaction_date(String transaction_date) {
        this.transaction_date = transaction_date;
    }

    public WithdrawalStatus getStatus() {
        return status;
    }

    public void setStatus(WithdrawalStatus status) {
        this.status = status;
    }

    public Long getPayer_id() {
        return payer_id;
    }

    public void setPayer_id(Long payer_id) {
        this.payer_id = payer_id;
    }

    public WithdrawalMedium getMedium() {
        return medium;
    }

    public void setMedium(WithdrawalMedium medium) {
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
                ", medium=" + medium +
                ", transaction_date='" + transaction_date + '\'' +
                ", amount=" + amount +
                ", description=" + description +
                ", status=" + status +
                ", payer_id=" + payer_id +
                ", type='" + type + '\'' +
                '}';
    }
}
