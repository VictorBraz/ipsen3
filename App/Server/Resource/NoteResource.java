package Server.Resource;

import Server.Model.Note;
import Server.Model.User;
import Server.Service.NoteService;
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
 * Created by Roel on 15-12-2016.
 */
@Singleton
@Path("/notes")
@Produces(MediaType.APPLICATION_JSON)
public class NoteResource {

    private final NoteService service;

    /**
     * Instantiates a new Note resource.
     *
     * @param service the service
     */
    @Inject
    public NoteResource(NoteService service){this.service = service;}

    /**
     * Retrieve all collection.
     *
     * @return the collection
     */
    @GET
    @JsonView(View.Public.class)
    @PermitAll
    public Collection<Note> retrieveAll(){
        return service.getAll();
    }

    /**
     * Retrieve note.
     *
     * @param id the id
     * @return the note
     */
    @GET
    @Path("/{id}")
    @JsonView(View.Public.class)
    public Note retrieve(@PathParam("id") int id){
        return service.get(id);
    }

    /**
     * Create.
     *
     * @param note the note
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @JsonView(View.Protected.class)
    public void create(Note note){
        service.add(note);
    }

    /**
     * Update.
     *
     * @param id            the id
     * @param authenticator the authenticator
     * @param note          the note
     */
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @JsonView(View.Protected.class)
    @PermitAll
    public void update(@PathParam("id") int id, @Auth User authenticator, Note note){
        service.update(note);
    }
}
