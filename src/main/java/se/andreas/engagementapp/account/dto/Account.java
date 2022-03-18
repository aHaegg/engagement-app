package se.andreas.engagementapp.account.dto;

import jakarta.json.bind.annotation.JsonbCreator;
import jakarta.json.bind.annotation.JsonbVisibility;
import se.andreas.engagementapp.account.model.FieldVisibilityStrategy;

import java.util.ArrayList;
import java.util.List;

@JsonbVisibility(FieldVisibilityStrategy.class)
public record Account(String name, List<BusinessObject> businessObjects) {

    @JsonbCreator
    public Account {
    }
}
