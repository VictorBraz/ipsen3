package Server.Service;

import Server.Model.Client;
import Server.Persistence.ClientDAO;
import com.google.inject.Inject;

import java.util.Collection;

/**
 * Created by Negin Nafissi on 9-12-2016.
 */
public class WorkerService {
    private final ClientDAO dao;

    @Inject
    public WorkerService(ClientDAO dao)
    {
        this.dao = dao;
    }

    public Collection<Client> getAll()
    {
        return dao.getAll();
    }

//    public Client get(int id)
//    {
//        return dao.get(id);
//    }
}
