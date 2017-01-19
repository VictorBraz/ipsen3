package Server.Resource;

import Server.Model.Client;
import Server.Model.User;
import Server.Service.ClientService;
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
 * Created by Victor on 12-12-2016.
 */
@Singleton
@Path("/clients")
@Produces(MediaType.APPLICATION_JSON)
public class ClientResource {

    private final ClientService service;

    @Inject
    public ClientResource(ClientService service){
        this.service = service;
    }

    @GET
    @JsonView(View.Public.class)
    //@RolesAllowed("3")
    @PermitAll
    public Collection<Client> retrieveActive(){
        return service.getAll();
    }

//    @GET
//    @JsonView(View.Public.class)
//    //@RolesAllowed("3")
//    @PermitAll
//    public Collection<Client> retrieveInactive(){
//        return service.getInactive();
//    }

    @GET
    @Path("/{id}")
    @JsonView(View.Public.class)
    public Client retrieve(@PathParam("id") int id){
        return service.get(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @JsonView(View.Protected.class)
    @PermitAll
    public void create(Client client){
        service.add(client);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @JsonView(View.Protected.class)
    @PermitAll
    public void update(Client client){
        service.update(client);
        System.out.println(client.getFirstname());
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @JsonView(View.Protected.class)
    @PermitAll
    public void delete(@PathParam("id") int id) {
        System.out.println(id);
        service.delete(id);
    }

//    @PUT
//    @Path("/{id}")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @JsonView(View.Protected.class)
//    @PermitAll
//    public void restore(@PathParam("id") int id) {
//        System.out.println(id);
//        service.restore(id);
//    }
}
