package Server.Resource;


import Server.Model.Document;
import Server.Service.DocumentService;
import Server.View;
import com.fasterxml.jackson.annotation.JsonView;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

/**
 * Created by vedadpiric on 05-02-17.
 */

@Singleton
@Path("/documents")
@Produces(MediaType.APPLICATION_JSON)
public class DocumentResource {
    private final DocumentService service;

    /**
     * Instantiates a new Client resource.
     *
     * @param service the service
     */
    @Inject
    public DocumentResource(DocumentService service){
        this.service = service;
    }



    /**
     * Retrieve documents.
     *
     * @param id the id
     * @return the documents
     */
    @GET
    @Path("/{id}")
    @JsonView(View.Public.class)
    public ArrayList<Document> retrieve(@PathParam("id") int id){
        return service.get(id);
    }
}
