package Server.Resource;

import Server.Model.Company;
import Server.Model.User;
import Server.Service.CompanyService;
import Server.View;
import com.fasterxml.jackson.annotation.JsonView;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import io.dropwizard.auth.Auth;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

/**
 * Created by Mitch on 12/9/2016.
 *
 * @author Mitch
 */
@Singleton
@Path("/companies")
@Produces(MediaType.APPLICATION_JSON)
public class CompanyResource
{
    private final CompanyService service;

    /**
     * Instantiates a new Company resource.
     *
     * @param service the service
     */
    @Inject
    public CompanyResource(CompanyService service)
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
    public Collection<Company> retrieveAll()
    {
        return service.getAll();
    }

    /**
     * Retrieve company.
     *
     * @param id the id
     * @return the company
     */
    @GET
    @Path("/{id}")
    @JsonView(View.Public.class)
    @PermitAll
    public Company retrieve(@PathParam("id") int id)
    {
        return service.get(id);
    }

    /**
     * Create.
     *
     * @param company the company
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @JsonView(View.Protected.class)
    @PermitAll
    public void create(Company company)
    {
        service.add(company);
    }

    /**
     * Update.
     *
     * @param id            the id
     * @param authenticator the authenticator
     * @param comp          the comp
     */
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @JsonView(View.Protected.class)
    @PermitAll
    public void update(@PathParam("id") int id, @Auth User authenticator, Company comp)
    {
        service.update(comp);
    }

    /**
     * Delete.
     *
     * @param id the id
     */
    @DELETE
    @Path("/{id}")
    @PermitAll
    public void delete(@PathParam("id") int id)
    {
        service.delete(id);
    }
}
