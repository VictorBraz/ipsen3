package Server.Model;


import Server.View;
import com.fasterxml.jackson.annotation.JsonView;
import org.hibernate.validator.constraints.Length;

/**
 * Created by Victor on 9-12-2016.
 */
public class Client {

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
    private String emaill;

    @Length(max = 10)
    @JsonView(View.Public.class)
    private String phonenumber;

    @JsonView(View.Public.class)
    private String tag;

    public Client(){

    }

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
        lastname = lastname;
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

    public String getEmaill() {
        return emaill;
    }

    public void setEmaill(String emaill) {
        this.emaill = emaill;
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
}
