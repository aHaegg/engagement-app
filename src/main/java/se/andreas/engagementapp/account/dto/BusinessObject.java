package se.andreas.engagementapp.account.dto;

import jakarta.json.bind.annotation.JsonbTypeDeserializer;

@JsonbTypeDeserializer(BusinessObjectDeserializer.class)
public sealed interface BusinessObject permits RoleInformation, StatusInformation, BalanceInformation {

}
