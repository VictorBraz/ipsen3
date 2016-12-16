package Server.Persistence;

import Server.Model.Client;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Victor on 9-12-2016.
 */
public class ClientDAO extends DatabaseDAO{

    private AddressDAO addressDAO;
    private PreparedStatement getClient;
    private PreparedStatement addClient;
    private PreparedStatement getAll;

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
            getAll = conn.prepareStatement("SELECT * FROM client");

        }catch (Exception e){

        }
    }

    public void addClient(Client client){
        try {
            addClient.setInt(1, client.getClientAddresId());
            addClient.setString(2, client.getFirstname());
            addClient.setString(3, client.getLastname());
            addClient.setString(4, client.getBirthdate());
            addClient.setString(5, client.getStudy());
            addClient.setString(6, client.getEmaill());
            addClient.setString(7, client.getPhonenumber());
            addClient.setString(8, client.getTag());

            addClient.executeUpdate();

//            addClient.close();

        }catch (Exception e){

        }
    }

    public List<Client> getAll(){
        List<Client> clients = new ArrayList<>();
        try{
            ResultSet rs = getAll.executeQuery();

            while (rs.next()){
                Client client = new Client();
                client.setId(rs.getInt(1));
                client.setClientAddresId(rs.getInt(2));
                client.setFirstname(rs.getString(3));
                client.setLastname(rs.getString(4));
                client.setBirthdate(rs.getString(5));
                client.setStudy(rs.getString(6));
                client.setEmail(rs.getString(7));
                client.setPhonenumber(rs.getString(8));
                client.setTag(rs.getString(9));
                clients.add(client);
            }
//            getAll.close();

        }catch (Exception e){

        }
        return clients;
    }

    public Client getClient(int id) {
        Client client = new Client();
        try {
            getClient.setInt(1, id);
            ResultSet rs = getClient.executeQuery();

            while (rs.next()) {
                client.setId(rs.getInt(1));
                client.setClientAddresId(rs.getInt(2));
                client.setFirstname(rs.getString(3));
                client.setLastname(rs.getString(4));
                client.setBirthdate(rs.getString(5));
                client.setStudy(rs.getString(6));
                client.setEmail(rs.getString(7));
                client.setPhonenumber(rs.getString(8));
                client.setTag(rs.getString(9));
            }
//            getClient.close();
        }catch (Exception e){

        }
        return client;
    }

}
