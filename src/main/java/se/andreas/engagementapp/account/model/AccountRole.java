package se.andreas.engagementapp.account.model;

import jakarta.json.bind.annotation.JsonbVisibility;

@JsonbVisibility(FieldVisibilityStrategy.class)
public class AccountRole {

    private final String name;
    private final Role role;

    public AccountRole(String name, Role role) {
        this.name = name;
        this.role = role;
    }

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
