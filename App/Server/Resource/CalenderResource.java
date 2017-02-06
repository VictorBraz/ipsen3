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

    /**
     * Instantiates a new Calender resource.
     *
     * @param service the service
     */
    @Inject
    public CalenderResource(CalenderService service) {
        this.service = service;
    }

    /**
     * Get all collection.
     *
     * @return the collection
     */
    @GET
    @JsonView(View.Public.class)
    @PermitAll
    public Collection<Calender> getAll() {
        return service.getAll();
    }


    /**
     * Retrieve calender.
     *
     * @param id the id
     * @return the calender
     */
    @GET
    @Path("/{id}")
    @JsonView(View.Public.class)
    public Calender retrieve(@PathParam("id") int id) {
        return service.get(id);
    }

    /**
     * Create.
     *
     * @param calender the calender
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @JsonView(View.Protected.class)
    @PermitAll
    public void create(Calender calender) {
        service.add(calender);
    }

    /**
     * Update.
     *
     * @param calender the calender
     */
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @JsonView(View.Protected.class)
    @PermitAll
    public void update(Calender calender) {

        service.update(calender);
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
