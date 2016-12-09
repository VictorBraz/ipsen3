package Server.Persistence;

import Server.Model.Client;

import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 * Created by Victor on 9-12-2016.
 */
public class ClientDAO extends DatabaseDAO{

    private AddressDAO addressDAO;
    private PreparedStatement getClient;
    private PreparedStatement addClient;

    public ClientDAO() throws Exception{
        super();
        prepareStatements();
        try {
            this.addressDAO = new AddressDAO();
        }catch (Exception e){

        }
    }

    private void prepareStatements(){
        try{
            getClient = conn.prepareStatement("SELECT * FROM client WHERE id=?");
            addClient = conn.prepareStatement("INSERT INTO client (clientaddressid, firstname, lastname, birthdate, study, email, phonenumber, tag) VALUES (?,?,?,?,?,?,?,?)");
        }catch (Exception e){

        }
    }

    public void addClient(Client client){
        try {

        }catch (Exception e){

        }
    }

    public ArrayList<Client> getAll(){
        ArrayList<Client> clients = new ArrayList<>();

        return clients;
    }

}
