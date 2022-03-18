package se.andreas.engagementapp.account.dto;

import jakarta.json.bind.annotation.JsonbVisibility;
import se.andreas.engagementapp.account.model.FieldVisibilityStrategy;

@JsonbVisibility(FieldVisibilityStrategy.class)
public final class StatusInformation implements BusinessObject {

    private Status status;

    public Status getStatus() {
        return status;
    }

    public enum Status {
        ACTIVE
    }
}
