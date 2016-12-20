package Server.Resource;

import Server.Model.Company;
import Server.Model.User;
import Server.Service.CompanyService;
import Server.View;
import com.fasterxml.jackson.annotation.JsonView;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import io.dropwizard.auth.Auth;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

/**
 * Created by Mitch on 12/9/2016.
 */
@Singleton
@Path("/companies")
@Produces(MediaType.APPLICATION_JSON)
public class CompanyResource
{
    private final CompanyService service;

    @Inject
    public CompanyResource(CompanyService service)
    {
        this.service = service;
    }

    @GET
    @JsonView(View.Public.class)
    @RolesAllowed("3")
    public Collection<Company> retrieveAll()
    {
        return service.getAll();
    }

    @GET
    @Path("/{id}")
    @JsonView(View.Public.class)
    @RolesAllowed("3")
    public Company retrieve(@PathParam("id") int id)
    {
        return service.get(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @JsonView(View.Protected.class)
    public void create(Company company)
    {
        //service.add(company);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @JsonView(View.Protected.class)
    @RolesAllowed("3")
    public void update(@PathParam("id") int id, @Auth User authenticator, User user)
    {
        //service.update(authenticator, id, user);
    }

    @DELETE
    @Path("/{id}")
    @RolesAllowed("3")
    public void delete(@PathParam("id") int id)
    {
        service.delete(id);
    }
}
