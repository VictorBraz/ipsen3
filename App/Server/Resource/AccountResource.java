package Server.Resource;

import Server.Model.Account;
import Server.Service.AccountService;
import Server.View;
import com.fasterxml.jackson.annotation.JsonView;
import com.google.inject.Singleton;
import io.dropwizard.auth.Auth;
import java.util.Collection;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


/**
 * Meer informatie over resources:
 *  https://jersey.java.net/documentation/latest/user-guide.html#jaxrs-resources
 *
 * @author Peter van Vliet
 */
@Singleton
@Path("/accounts")
@Produces(MediaType.APPLICATION_JSON)
public class AccountResource
{
    private final AccountService service;

    @Inject
    public AccountResource(AccountService service)
    {
        this.service = service;
    }

    @GET
    @JsonView(View.Public.class)
    @RolesAllowed("GUEST")
    public Collection<Account> retrieveAll()
    {
        return service.getAll();
    }

    @GET
    @Path("/{id}")
    @JsonView(View.Public.class)
    @RolesAllowed("GUEST")
    public Account retrieve(@PathParam("id") int id)
    {
        return service.getAccount(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @JsonView(View.Protected.class)
    public void create(Account account)
    {
        service.addAccount(account);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @JsonView(View.Protected.class)
    @RolesAllowed("GUEST")
    public void update(@PathParam("id") int id, @Auth Account authenticator, Account account)
    {
//        service.update(authenticator, id, account);
    }

    @DELETE
    @Path("/{id}")
    @RolesAllowed("ADMIN")
    public void delete(@PathParam("id") int id)
    {
//        service.delete(id);
    }

    @GET
    @Path("/me")
    @JsonView(View.Private.class)
    public Account authenticate(@Auth Account authenticator)
    {
        return authenticator;
    }
}
