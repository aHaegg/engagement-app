package se.andreas.engagementapp.rs;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import se.andreas.engagementapp.account.AccountClient;
import se.andreas.engagementapp.account.AccountMapper;
import se.andreas.engagementapp.account.model.Account;

@Path("engagement")
public class EngagementRs {

    @Inject
    @RestClient
    private AccountClient accountClient;

    @Inject
    private AccountMapper accountMapper;

    @GET
    @Path("account/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Account getAccount(@PathParam("id") Integer id) {
        se.andreas.engagementapp.account.dto.Account account = accountClient.getAccount(id);
        return accountMapper.map(account);
    }
}
