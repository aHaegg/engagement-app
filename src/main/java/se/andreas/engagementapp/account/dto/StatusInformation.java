package se.andreas.engagementapp.account.dto;

import jakarta.json.bind.annotation.JsonbCreator;
import jakarta.json.bind.annotation.JsonbVisibility;
import se.andreas.engagementapp.account.model.FieldVisibilityStrategy;

@JsonbVisibility(FieldVisibilityStrategy.class)
public record StatusInformation(Status status) implements BusinessObject {

    @JsonbCreator
    public StatusInformation {
    }

    public enum Status {
        ACTIVE
    }
}
