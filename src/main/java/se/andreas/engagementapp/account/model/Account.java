package se.andreas.engagementapp.account.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Account {

    private final String name;

    private String ownerName;
    private StatusType status;
    private final List<AccountRole> accountRoles;
    private Balance balance;
    private BigDecimal interest;

    public Account(String name) {
        this.name = name;
        this.accountRoles = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public void setStatus(StatusType status) {
        this.status = status;
    }

    public StatusType getStatus() {
        return status;
    }

    public List<AccountRole> getAccountRoles() {
        return accountRoles;
    }

    public void setBalance(Balance balance) {
        this.balance = balance;
    }

    public Balance getBalance() {
        return balance;
    }

    public void setInterest(BigDecimal interest) {
        this.interest = interest;
    }

    public BigDecimal getInterest() {
        return interest;
    }
}
