package com.haggardinnovations.bankingapi.enumerations;

import com.haggardinnovations.bankingapi.domains.Bill;

public enum BillStatus {
    PENDING("PENDING"), CANCELLED("CANCELLED"), COMPLETED("COMPLETED"), RECURRING("RECURRING");

    private String value;

    BillStatus(String value) {
        this.value = value;
    }

}
