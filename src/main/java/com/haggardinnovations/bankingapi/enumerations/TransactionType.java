package com.haggardinnovations.bankingapi.enumerations;

public enum TransactionType{
    P2P("P2P"), DEPOSIT("DEPOSIT"), WITHDRAWAL("WITHDRAWAL");

    private final String value;

    TransactionType(String value) {
        this.value = value;
    }
}
