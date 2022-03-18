package se.andreas.engagementapp.account.dto;

import jakarta.json.bind.annotation.JsonbVisibility;
import se.andreas.engagementapp.account.model.FieldVisibilityStrategy;

import java.math.BigDecimal;

@JsonbVisibility(FieldVisibilityStrategy.class)
public final class BalanceInformation implements BusinessObject {

    private BigDecimal balance;
    private String currency;
    private BigDecimal interest;

    public BigDecimal getBalance() {
        return balance;
    }

    public String getCurrency() {
        return currency;
    }

    public BigDecimal getInterest() {
        return interest;
    }
}
