package se.andreas.engagementapp.account.dto;

import jakarta.json.bind.annotation.JsonbCreator;
import jakarta.json.bind.annotation.JsonbVisibility;
import se.andreas.engagementapp.account.model.FieldVisibilityStrategy;

@JsonbVisibility(FieldVisibilityStrategy.class)
public record RoleInformation(String name, Role role) implements BusinessObject {

    @JsonbCreator
    public RoleInformation {
    }

    public enum Role {
        CO_OWNER, OWNER
    }
}
