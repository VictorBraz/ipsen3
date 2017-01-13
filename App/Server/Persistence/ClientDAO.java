package Server.Persistence;

import Server.Model.Address;
import Server.Model.Client;
import Server.Model.Note;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Victor on 9-12-2016.
 */
public class ClientDAO extends DatabaseDAO{

    private AddressDAO addressDAO;
    private NoteDAO noteDAO;
    private PreparedStatement getClient;
    private PreparedStatement addClient;
    private PreparedStatement getAll;
    private PreparedStatement updateClient;

    public ClientDAO() throws Exception{
        super();
        prepareStatements();
        try {
            this.addressDAO = new AddressDAO();
            this.noteDAO = new NoteDAO();
        }catch (Exception e){

        }
    }

    private void prepareStatements(){
        try{
            getClient = conn.prepareStatement("SELECT * FROM client WHERE id=?");
            addClient = conn.prepareStatement("INSERT INTO client (clientaddressid, firstname, lastname, birthdate, study, email, phonenumber, tag) VALUES (?,?,?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
            getAll = conn.prepareStatement("SELECT * FROM client");
            updateClient = conn.prepareStatement("UPDATE client SET clientaddressid=?, firstname=?, lastname=?, birthdate=?, study=?, email=?, phonenumber=?, tag=? WHERE id=?");

        }catch (Exception e){

        }
    }

    public void addClient(Client client){

        try {
            Address address = new Address();
            address.setAddress(client.getAddress());
            address.setCity(client.getCity());
            address.setPostcode(client.getPostcode());

            client.setClientAddresId(addressDAO.addAddress(address).getId());

            addClient.setInt(1, client.getClientAddresId());
            addClient.setString(2, client.getFirstname());
            addClient.setString(3, client.getLastname());
            addClient.setString(4, client.getBirthdate());
            addClient.setString(5, client.getStudy());
            addClient.setString(6, client.getEmailAddress());
            addClient.setString(7, client.getPhonenumber());
            addClient.setString(8, client.getTag());

            addClient.executeUpdate();

            ResultSet rs = addClient.getGeneratedKeys();
            if (rs.next()){
                client.setId(rs.getInt("id"));
            }

            Note note = new Note();
            note.setOwnerID(client.getId());
            note.setText(client.getNoteText());
            System.out.println(client.getNoteText());
            noteDAO.addNote(note);

//            addClient.close();

        }catch (Exception e){
            e.printStackTrace();
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
                client.setEmailAddress(rs.getString(7));
                client.setPhonenumber(rs.getString(8));
                client.setTag(rs.getString(9));

                Address address = addressDAO.getAddress(rs.getInt(2));

                client.setAddress(address.getAddress());
                client.setCity(address.getCity());
                client.setPostcode(address.getPostcode());

                Note note = noteDAO.getNote(client.getId());
                client.setNoteText(note.getText());

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

                Address address = addressDAO.getAddress(client.getClientAddresId());
                client.setAddress(address.getAddress());
                client.setCity(address.getCity());
                client.setPostcode(address.getPostcode());


                client.setFirstname(rs.getString(3));
                client.setLastname(rs.getString(4));
                client.setBirthdate(rs.getString(5));
                client.setStudy(rs.getString(6));
                client.setEmailAddress(rs.getString(7));
                client.setPhonenumber(rs.getString(8));
                client.setTag(rs.getString(9));

                Note note = noteDAO.getNote(client.getId());
                client.setNoteText(note.getText());
            }
        }catch (Exception e){

        }
        return client;
    }

    public void update(Client client){
        Address address = new Address();
        address.setAddress(client.getAddress());
        address.setCity(client.getCity());
        address.setPostcode(client.getPostcode());
        address.setId(client.getClientAddresId());

        Note note = new Note();
        note.setText(client.getNoteText());
        note.setOwnerID(client.getId());

        try {
            noteDAO.update(note);
            addressDAO.UpdateAddress(address);

            updateClient.setInt(1, client.getClientAddresId());
            updateClient.setString(2, client.getFirstname());
            updateClient.setString(3, client.getLastname());
            updateClient.setString(4, client.getBirthdate());
            updateClient.setString(5, client.getStudy());
            updateClient.setString(6, client.getEmailAddress());
            updateClient.setString(7, client.getPhonenumber());
            updateClient.setString(8, client.getTag());

            updateClient.setInt(9, client.getId());
            updateClient.executeUpdate();


        }catch (Exception e){

        }
    }

}
