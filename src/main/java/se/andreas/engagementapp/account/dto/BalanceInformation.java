package se.andreas.engagementapp.account.dto;

import jakarta.json.bind.annotation.JsonbCreator;
import jakarta.json.bind.annotation.JsonbVisibility;
import se.andreas.engagementapp.account.model.FieldVisibilityStrategy;

import java.math.BigDecimal;

@JsonbVisibility(FieldVisibilityStrategy.class)
public record BalanceInformation(BigDecimal balance, String currency, BigDecimal interest) implements BusinessObject {

    @JsonbCreator
    public BalanceInformation {
    }
}
