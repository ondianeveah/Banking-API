package com.haggardinnovations.bankingapi.enumerations;

public enum TransactionStatus {
    PENDING("PENDING"), CANCELLED("CANCELLED"), COMPLETED("COMPLETED");


    private String value;

    TransactionStatus(String value) {
        this.value = value;
    }
}
