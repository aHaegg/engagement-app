package se.andreas.engagementapp.account;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import se.andreas.engagementapp.account.dto.Account;

@RegisterRestClient(configKey = "AccountClient", baseUri = "http://localhost:8080")
@Path("account")
public interface AccountClient extends AutoCloseable {

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Account getAccount(@PathParam("id") Integer id);
}
