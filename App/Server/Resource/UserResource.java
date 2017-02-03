package Server.Resource;

import Server.View;
import com.fasterxml.jackson.annotation.JsonView;
import com.google.inject.Singleton;
import io.dropwizard.auth.Auth;
import java.util.Collection;
import javax.annotation.security.PermitAll;
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
import Server.Service.UserService;
import Server.Model.User;


/**
 * Meer informatie over resources:
 * https://jersey.java.net/documentation/latest/user-guide.html#jaxrs-resources
 *
 * @author Peter van Vliet, Negin Nafissi
 */
@Singleton
@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource
{
    private final UserService service;

    /**
     * Instantiates a new User resource.
     *
     * @param service the service
     */
    @Inject
    public UserResource(UserService service)
    {
        this.service = service;
    }

    /**
     * Retrieve all collection.
     *
     * @return the collection
     */
    @GET
    @JsonView(View.Public.class)
    @PermitAll
    public Collection<User> retrieveAll()
    {
        return service.getAll();
    }

    /**
     * Retrieve user.
     *
     * @param id the id
     * @return the user
     */
    @GET
    @Path("/{id}")
    @JsonView(View.Public.class)
    @PermitAll
    public User retrieve(@PathParam("id") int id)
    {
        return service.get(id);
    }

    /**
     * Create.
     *
     * @param user the user
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @JsonView(View.Protected.class)
    @RolesAllowed("1")
    public void create(User user)
    {
        service.add(user);
    }

    /**
     * Update.
     *
     * @param id            the id
     * @param authenticator the authenticator
     * @param user          the user
     */
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @JsonView(View.Protected.class)
    @RolesAllowed("1")
    public void update(@PathParam("id") int id, @Auth User authenticator, User user)
    {
        service.update(authenticator, id, user);
    }

    /**
     * Delete.
     *
     * @param id the id
     */
    @DELETE
    @Path("/{id}")
    @RolesAllowed("1")
    public void delete(@PathParam("id") int id)
    {
        service.delete(id);
    }

    /**
     * Authenticate user.
     *
     * @param authenticator the authenticator
     * @return the user
     */
    @GET
    @Path("/me")
    @JsonView(View.Private.class)
    @PermitAll
    public User authenticate(@Auth User authenticator)
    {
        return authenticator;
    }
}
