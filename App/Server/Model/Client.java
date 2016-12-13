package Server.Model;


import Server.View;
import com.fasterxml.jackson.annotation.JsonView;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by Victor on 9-12-2016.
 */
public class Client {

    @NotEmpty
    @JsonView(View.Public.class)
    private int id;

    @NotEmpty
    @JsonView(View.Public.class)
    private int clientAddressId;

    @NotEmpty
    @Length(min = 1, max = 100)
    @JsonView(View.Public.class)
    private String firstName;

    @NotEmpty
    @Length(min = 1, max = 100)
    @JsonView(View.Public.class)
    private String lastName;

    @NotEmpty
    @JsonView(View.Public.class)
    private String birthDate;

    @NotEmpty
    @Length(min = 1, max = 100)
    @JsonView(View.Public.class)
    private String study;

    @NotEmpty
    @Email
    @JsonView(View.Public.class)
    private String email;

    @NotEmpty
    @Length(min = 1, max = 100)
    @JsonView(View.Public.class)
    private String phoneNumber;

    @JsonView(View.Public.class)
    private String tag;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientAddressId() {
        return clientAddressId;
    }

    public void setClientAddressId(int clientAddresId) {
        this.clientAddressId = clientAddressId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getStudy() {
        return study;
    }

    public void setStudy(String study) {
        this.study = study;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
