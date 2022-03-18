package se.andreas.engagementapp.account.dto;

import jakarta.json.bind.annotation.JsonbVisibility;
import se.andreas.engagementapp.account.model.FieldVisibilityStrategy;

import java.util.ArrayList;
import java.util.List;

@JsonbVisibility(FieldVisibilityStrategy.class)
public final class Account {

    private String name;
    private List<BusinessObject> businessObjects;

    public Account() {
        this.businessObjects = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<BusinessObject> getBusinessObjects() {
        return businessObjects;
    }
}
