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
    private String address;

    @JsonView(View.Public.class)
    private String city;

    @JsonView(View.Public.class)
    private String postcode;

    @JsonView(View.Public.class)
    private String noteText;

    @JsonView(View.Public.class)
    private Boolean active;

    public int getId() {
        return id;
    }

    public int getClientAddresId() {
        return clientAddresId;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public String getStudy() {
        return study;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public String getTag() {
        return tag;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getNoteText() {
        return noteText;
    }

    public Boolean getActive() {
        return active;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setClientAddresId(int clientAddresId) {
        this.clientAddresId = clientAddresId;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public void setStudy(String study) {
        this.study = study;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public void setNoteText(String noteText) {
        this.noteText = noteText;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
