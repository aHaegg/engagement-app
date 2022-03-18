package se.andreas.engagementapp.account.model;

import jakarta.json.bind.annotation.JsonbVisibility;

@JsonbVisibility(FieldVisibilityStrategy.class)
public record AccountRole(String name, Role role) {

    public enum Role {
        OWNER, OTHER;

        public static Role map(String name) {
            try {
                return Role.valueOf(name);
            } catch (IllegalArgumentException e) {
                return OTHER;
            }
        }
    }
}
