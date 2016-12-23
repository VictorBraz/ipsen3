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
            addAddress = conn.prepareStatement("INSERT INTO address (address, zipcode, city) VALUES (?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
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
                address.setPostcode(rs.getString(3));
                address.setCity(rs.getString(4));
            }


        }catch (Exception e){

        }
        return address;

    }

    public ArrayList<Address> getAll(){
        ArrayList<Address> addresses = new ArrayList<>();


        return addresses;
    }

    public Address addAddress(Address address){
        try{
            addAddress.setString(1, address.getAddress());
            addAddress.setString(2, address.getPostcode());
            addAddress.setString(3, address.getCity());

            addAddress.executeUpdate();
            ResultSet rs = addAddress.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                address.setId(id);
            }
            addAddress.close();
        }catch(Exception e){

        }
        return address;
    }
}
