package Server.Service;

import Server.Model.Client;
import Server.Model.User;
import Server.Persistence.ClientDAO;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Collection;

/**
 * Created by Victor on 12-12-2016.
 */
@Singleton
public class ClientService extends BaseService<Client>{

    private final ClientDAO dao;

    @Inject
    public ClientService(ClientDAO dao){
        this.dao = dao;
    }
    public Collection<Client>  getAll(){
        return dao.getAll();
    }
    public Client get(int id){
        return dao.getClient(id);
    }
    public void add(Client client){
        dao.addClient(client);
    }
    public void update(Client client) {
        dao.update(client);
    }

}
