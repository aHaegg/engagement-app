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
            if(businessObject instanceof RoleInformation a) {
                if(a.role() == OWNER) {
                    account.setOwnerName(a.name());
                } else {
                    AccountRole accountRole = new AccountRole(a.name(), Role.map(a.role().name()));
                    account.getAccountRoles().add(accountRole);
                }

            } else if(businessObject instanceof StatusInformation s) {
                account.setStatus(StatusType.map(s.status().name()));

            } else if(businessObject instanceof BalanceInformation b) {
                account.setBalance(new Balance(b.balance(), b.currency()));
                account.setInterest(b.interest());

            } else {
                throw new RuntimeException("This should never happen");
            }
        }

        return account;
    }
}
