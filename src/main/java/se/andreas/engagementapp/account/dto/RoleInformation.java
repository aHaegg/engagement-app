package se.andreas.engagementapp.account.dto;

import jakarta.json.bind.annotation.JsonbVisibility;
import se.andreas.engagementapp.account.model.FieldVisibilityStrategy;

@JsonbVisibility(FieldVisibilityStrategy.class)
public final class RoleInformation implements BusinessObject {

    private String name;
    private Role role;

    public String getName() {
        return name;
    }

    public Role getRole() {
        return role;
    }

    public enum Role {
        CO_OWNER, OWNER
    }
}
