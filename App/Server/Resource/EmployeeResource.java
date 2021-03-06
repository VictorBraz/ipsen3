package Server.Resource;


import Server.Model.Employee;
import Server.Model.User;
import Server.Service.EmployeeService;
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
 * Created by Negin Nafissi on 13-12-2016.
 */
@Singleton
@Path("/employees")
@Produces(MediaType.APPLICATION_JSON)
public class EmployeeResource {

    private final EmployeeService service;

    /**
     * Instantiates a new Employee resource.
     *
     * @param service the service
     */
    @Inject
    public EmployeeResource(EmployeeService service) {
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
    public Collection<Employee> retrieveAll() {
        return service.getAll();
    }

    /**
     * Retrieve employee.
     *
     * @param id the id
     * @return the employee
     */
    @GET
    @Path("/{id}")
    @JsonView(View.Public.class)
    public Employee retrieve(@PathParam("id") int id) {
        return service.get(id);
    }

    /**
     * Create.
     *
     * @param employee the employee
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @JsonView(View.Protected.class)
    public void create(Employee employee) {
        service.add(employee);
    }

    /**
     * Update.
     *
     * @param id            the id
     * @param authenticator the authenticator
     * @param employee      the employee
     */
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @JsonView(View.Protected.class)
    @PermitAll
    public void update(@PathParam("id") int id, @Auth User authenticator, Employee employee) {
        service.update(employee);
    }

    /**
     * Delete.
     *
     * @param id the id
     */
    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @JsonView(View.Protected.class)
    @PermitAll
    public void delete(@PathParam("id") int id) {
        service.delete(id);
    }
}
