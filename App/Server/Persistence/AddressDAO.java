package Server.Persistence;

import Server.Model.Address;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
        try{
            getAddress.setInt(1, id);
            ResultSet rs = getAddress.executeQuery();
            while(rs.next()){
                address.setId(rs.getInt(1));
                address.setAddress(rs.getString(2));
                address.setZipcode(rs.getString(3));
                address.setCity(rs.getString(4));
            }

            getAddress.close();

        }catch (Exception e){

        }
        return address;

    }

    public ArrayList<Address> getAll(){
        ArrayList<Address> addresses = new ArrayList<>();


        return addresses;
    }

    public void addAddress(Address address){
        try{
            addAddress.setString(1, address.getAddress());
            addAddress.setString(2, address.getZipcode());
            addAddress.setString(3, address.getCity());

            addAddress.execute();

            addAddress.close();
        }catch(Exception e){

        }
    }
}
