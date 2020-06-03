package com.haggardinnovations.bankingapi.domains;

import com.haggardinnovations.bankingapi.enumerations.DepositMedium;
import com.haggardinnovations.bankingapi.enumerations.DepositStatus;
import com.haggardinnovations.bankingapi.enumerations.DepositType;

import javax.persistence.*;

@Entity
public class Deposit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private DepositType type;
    private String transaction;
    private DepositStatus status;
    private Long payee_id;
    private DepositMedium medium;
    private Double amount;
    private String description;

    public Deposit(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DepositType getType() {
        return type;
    }

    public void setType(DepositType type) {
        this.type = type;
    }

    public String getTransaction() {
        return transaction;
    }

    public void setTransaction(String transaction) {
        this.transaction = transaction;
    }

    public DepositStatus getStatus() {
        return status;
    }

    public void setStatus(DepositStatus status) {
        this.status = status;
    }

    public Long getPayee_id() {
        return payee_id;
    }

    public void setPayee_id(Long payee_id) {
        this.payee_id = payee_id;
    }

    public DepositMedium getMedium() {
        return medium;
    }

    public void setMedium(DepositMedium medium) {
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
                ", transaction='" + transaction + '\'' +
                ", status=" + status +
                ", payee_id=" + payee_id +
                ", medium=" + medium +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                '}';
    }
}
