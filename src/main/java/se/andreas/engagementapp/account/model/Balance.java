package se.andreas.engagementapp.account.model;

import jakarta.json.bind.annotation.JsonbVisibility;

import java.math.BigDecimal;

@JsonbVisibility(FieldVisibilityStrategy.class)
public class Balance {

    private final BigDecimal balance;
    private final String currency;

    public Balance(BigDecimal balance, String currency) {
        this.balance = balance;
        this.currency = currency;
    }
}
