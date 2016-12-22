package Server.Resource;

import Server.Model.Note;
import Server.Model.User;
import Server.Service.NoteService;
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
 * Created by Roel on 15-12-2016.
 */
@Singleton
@Path("/notes")
@Produces(MediaType.APPLICATION_JSON)
public class NoteResource {
    private final NoteService service;

    @Inject
    public NoteResource(NoteService service){this.service = service;}

    @GET
    @JsonView(View.Public.class)
    @RolesAllowed("MEDEWERKER")
    public Collection<Note> retrieveAll(){
        return service.getAll();
    }

    @GET
    @Path("/{id}")
    @JsonView(View.Public.class)
    public Note retrieve(@PathParam("id") int id){
        return service.get(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @JsonView(View.Protected.class)
    public void create(Note note){
        service.add(note);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @JsonView(View.Protected.class)
    @RolesAllowed("MEDEWERKER")
    public void update(@PathParam("id") int id, @Auth User authenticator, Note note){
        service.edit(note);
    }
}
