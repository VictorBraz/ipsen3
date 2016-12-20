package Server.Model;

import Server.View;
import com.fasterxml.jackson.annotation.JsonView;

/**
 * Created by Victor on 9-12-2016.
 */
public class Address {

    private int id;
    @JsonView(View.Public.class)
    private String address;

    @JsonView(View.Public.class)
    private String zipcode;

    @JsonView(View.Public.class)
    private String city;

    @JsonView(View.Public.class)
    private String street;

    @JsonView(View.Public.class)
    private String streetnumber;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreetnumber() {
        return streetnumber;
    }

    public void setStreetnumber(String streetnumber) {
        this.streetnumber = streetnumber;
    }

    public String getAddress() {
        return address = street + " " + streetnumber;

    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
