package se.andreas.engagementapp.account.model;

public enum StatusType {
    ACTIVE, UNKNOWN;

    public static StatusType map(String name) {
        try {
            return StatusType.valueOf(name);
        } catch (IllegalArgumentException e) {
            return UNKNOWN;
        }
    }
}
