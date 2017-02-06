package Server.Service;

import Server.Model.Client;
import Server.Model.User;
import Server.Persistence.ClientDAO;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Collection;

/**
 * The type Client service.
 *
 * @author Victor Machado Braz, Bernd
 */
@Singleton
public class ClientService extends BaseService<Client>{

    private final ClientDAO dao;

    @Inject
    private ClientService(ClientDAO dao){
        this.dao = dao;
    }

    /**
     * Get all collection.
     *
     * @return the collection
     */
    public Collection<Client>  getAll(){
        return dao.getAll();
    }

    /**
     * Get client.
     *
     * @param id the id
     * @return the client
     */
    public Client get(int id){
        return dao.getClient(id);
    }

    /**
     * Add.
     *
     * @param client the client
     */
    public void add(Client client){
        dao.addClient(client);
    }

    /**
     * Update.
     *
     * @param client the client
     */
    public void update(Client client) {
        dao.update(client);
    }

    /**
     * Delete.
     *
     * @param id the id
     */
    public void delete(int id) {
        dao.delete(id);
    }

}
