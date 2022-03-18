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
        Account account = new Account(dtoAccount.getName());

        for (BusinessObject businessObject : dtoAccount.getBusinessObjects()) {
            if(businessObject instanceof RoleInformation) {
                RoleInformation a = (RoleInformation) businessObject;
                if(a.getRole() == OWNER) {
                    account.setOwnerName(a.getName());
                } else {
                    AccountRole accountRole = new AccountRole(a.getName(), Role.map(a.getRole().name()));
                    account.getAccountRoles().add(accountRole);
                }

            } else if(businessObject instanceof StatusInformation) {
                account.setStatus(StatusType.map(((StatusInformation) businessObject).getStatus().name()));

            } else if(businessObject instanceof BalanceInformation) {
                BalanceInformation balanceInformation = (BalanceInformation) businessObject;
                account.setBalance(new Balance(balanceInformation.getBalance(), balanceInformation.getCurrency()));
                account.setInterest(balanceInformation.getInterest());

            } else {
                throw new RuntimeException("This should never happen");
            }
        }

        return account;
    }
}
