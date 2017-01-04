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
    private String postcode;

    @JsonView(View.Public.class)
    private String city;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostcode() {
        return this.postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
