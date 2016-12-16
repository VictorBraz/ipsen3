package Server.Resource;


import Server.Model.Employee;
import Server.Model.User;
import Server.Service.EmployeeService;
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
 * Created by Negin on 13-12-2016.
 */

@Singleton
@Path("/employees")
@Produces(MediaType.APPLICATION_JSON)
public class EmployeeResource {

    private final EmployeeService service;

    @Inject
    public EmployeeResource(EmployeeService service){
        this.service = service;
    }

    @GET
    @JsonView(View.Public.class)
    @RolesAllowed("MEDEWERKER")
    public Collection<Employee> retrieveAll(){
        return service.getAll();
    }

    @GET
    @Path("/{id}")
    @JsonView(View.Public.class)
    public Employee retrieve(@PathParam("id") int id){
        return service.get(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @JsonView(View.Protected.class)
    public void create(Employee employee){
        service.add(employee);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @JsonView(View.Protected.class)
    @RolesAllowed("MEDEWERKER")
    public void update(@PathParam("id") int id, @Auth User authenticator, Employee employee){

    }

    @DELETE
    @Path("/{id}")
    @RolesAllowed("ADMIN")
    public void delete(@PathParam("id") int id)
    {

    }
}