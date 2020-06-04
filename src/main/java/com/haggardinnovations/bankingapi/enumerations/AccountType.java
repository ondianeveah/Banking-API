package com.haggardinnovations.bankingapi.enumerations;

public enum AccountType {
    SAVINGS("SAVINGS"), CHECKING("CHECKING"), CREDIT("CREDIT");

    private String value;

    AccountType(String value) {
        this.value = value;
    }

}
