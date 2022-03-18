package se.andreas.engagementapp.account.model;

import jakarta.json.bind.annotation.JsonbVisibility;

import java.math.BigDecimal;

@JsonbVisibility(FieldVisibilityStrategy.class)
public record Balance(BigDecimal balance, String currency) {

}
