package Server.Service;

import Server.Model.Document;
import Server.Persistence.DocumentDAO;

import javax.inject.Inject;
import java.util.ArrayList;

/**
 * Created by vedadpiric on 05-02-17.
 */
public class DocumentService extends BaseService<Document>{

    private final DocumentDAO dao;
    @Inject
    private DocumentService(DocumentDAO dao){
        this.dao = dao;
    }


    /**
     * Get document
     *
     * @param id the id
     * @return the document
     */
    public ArrayList<Document> get(int id){
        return dao.getAllDocuments(id);
    }
}
