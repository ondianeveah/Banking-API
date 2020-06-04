package com.haggardinnovations.bankingapi.enumerations;

public enum TransactionMedium {
    BALANCE("BALANCE"), REWARDS("REWARDS");

    private String value;

    TransactionMedium(String value) {
        this.value = value;
    }
}
