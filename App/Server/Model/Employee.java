package Server.Model;

import Server.View;
import com.fasterxml.jackson.annotation.JsonView;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by Negin on 13-12-2016.
 */
public class Employee {

    @NotEmpty
    @JsonView(View.Public.class)
    private int id;

    private int employeeAddressID;

    @NotEmpty
    @JsonView(View.Public.class)
    private String firstName;

    @NotEmpty
    @JsonView(View.Public.class)
    private String lastName;

    @NotEmpty
    @JsonView(View.Public.class)
    private String birthDate;

    @JsonView(View.Public.class)
    private String study;

    @NotEmpty
    @JsonView(View.Public.class)
    private String email;

    @JsonView(View.Public.class)
    private String phoneNumber;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmployeeAddressID() {
        return employeeAddressID;
    }

    public void setEmployeeAddressID(int employeeAddressID) {
        this.employeeAddressID = employeeAddressID;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getNoteText() {
        return noteText;
    }

    public void setNoteText(String noteText) {
        this.noteText = noteText;
    }
}
