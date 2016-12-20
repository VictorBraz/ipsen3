package Server.Model;


import Server.View;
import com.fasterxml.jackson.annotation.JsonView;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by Victor on 9-12-2016.
 */
public class Client {

    @NotEmpty
    @JsonView(View.Public.class)
    private int id;

    private int clientAddresId;

    @JsonView(View.Public.class)
    private String firstname;

    @JsonView(View.Public.class)
    private String lastname;

    @JsonView(View.Public.class)
    private String birthdate;

    @JsonView(View.Public.class)
    private String study;

    @JsonView(View.Public.class)
    private String emailAddress;

    @JsonView(View.Public.class)
    private String phonenumber;

    @JsonView(View.Public.class)
    private String tag;

    @JsonView(View.Public.class)
    private String street;

    @JsonView(View.Public.class)
    private String city;

    @JsonView(View.Public.class)
    private String zipCode;

    @JsonView(View.Public.class)
    private String streetNumber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientAddresId() {
        return clientAddresId;
    }

    public void setClientAddresId(int clientAddresId) {
        this.clientAddresId = clientAddresId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getStudy() {
        return study;
    }

    public void setStudy(String study) {
        this.study = study;
    }


    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getStreetName() {
        return street;
    }

    public void setStreetName(String street) {
        this.street = street;
    }

    public String getCityName() {
        return city;
    }

    public void setCityName(String city) {
        this.city = city;
    }
    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }
}
