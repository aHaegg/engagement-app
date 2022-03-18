package se.andreas.engagementapp.account;

import jakarta.enterprise.context.RequestScoped;
import se.andreas.engagementapp.account.dto.BalanceInformation;
import se.andreas.engagementapp.account.dto.BusinessObject;
import se.andreas.engagementapp.account.dto.RoleInformation;
import se.andreas.engagementapp.account.dto.StatusInformation;
import se.andreas.engagementapp.account.model.Account;
import se.andreas.engagementapp.account.model.AccountRole;
import se.andreas.engagementapp.account.model.AccountRole.Role;
import se.andreas.engagementapp.account.model.Balance;
import se.andreas.engagementapp.account.model.StatusType;

import static se.andreas.engagementapp.account.dto.RoleInformation.Role.OWNER;

@RequestScoped
public class AccountMapper {

    public Account map(se.andreas.engagementapp.account.dto.Account dtoAccount) {
        Account account = new Account(dtoAccount.name());

        for (BusinessObject businessObject : dtoAccount.businessObjects()) {
            switch (businessObject) {
                case RoleInformation a && a.role() == OWNER -> account.setOwnerName(a.name());
                case RoleInformation a -> account.getAccountRoles().add(new AccountRole(a.name(), Role.map(a.role().name())));
                case StatusInformation s -> account.setStatus(StatusType.map(s.status().name()));
                case BalanceInformation b -> {
                    account.setBalance(new Balance(b.balance(), b.currency()));
                    account.setInterest(b.interest());
                }
                case null -> {} // Do nothing
            }
        }

        return account;
    }
}
