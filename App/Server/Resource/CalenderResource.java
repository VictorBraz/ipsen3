package Server.Resource;

import Server.Model.Calender;
import Server.Service.CalenderService;
import Server.View;
import com.fasterxml.jackson.annotation.JsonView;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import javax.annotation.security.PermitAll;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

/**
 * Created by vedadpiric on 23-01-17.
 */
@Singleton
@Path("/calender")
@Produces(MediaType.APPLICATION_JSON)

public class CalenderResource {

    private final CalenderService service;

    @Inject
    public CalenderResource(CalenderService service){
        this.service = service;
    }

    @GET
    @JsonView(View.Public.class)
    //@RolesAllowed("3")
    @PermitAll
    public Collection<Calender> getAll(){
        return service.getAll();
    }



    @GET
    @Path("/{id}")
    @JsonView(View.Public.class)
    public Calender retrieve(@PathParam("id") int id){
        return service.get(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @JsonView(View.Protected.class)
    @PermitAll
    public void create(Calender calender){
        service.add(calender);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @JsonView(View.Protected.class)
    @PermitAll
    public void update(Calender calender){
        service.update(calender);
        System.out.println(calender.getEventName());
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


}
