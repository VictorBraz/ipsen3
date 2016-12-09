package Server.Persistence;

import Server.Model.Address;

import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 * Created by Victor on 9-12-2016.
 */
public class AddressDAO extends DatabaseDAO{

    private PreparedStatement getAddress;
    private PreparedStatement addAddress;

    public AddressDAO() throws Exception{
        super();
        prepareStatements();
    }

    private void prepareStatements(){
        try{
            getAddress = conn.prepareStatement("SELECT * FROM address WHERE id=?");
            addAddress = conn.prepareStatement("INSERT INTO address (address, zipcode, city) VALUES (?,?,?)");
        }catch (Exception e){

        }
    }

    public Address getAddress(int id){
        Address address = new Address();
        return address;
    }

    public ArrayList<Address> getAll(){
        ArrayList<Address> addresses = new ArrayList<>();

        return addresses;
    }

    public void addAddress(Address address){

    }
}
