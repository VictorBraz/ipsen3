package Server.Model;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Server.View;
import com.fasterxml.jackson.annotation.JsonView;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author Mitch van Wijngaarden
 * @author Bernd
 */
public class Company {

    @NotEmpty
    @JsonView(View.Public.class)
    private int id;

    private int companyAddressID;

    @NotEmpty
    @Length(min = 1, max = 100)
    @JsonView(View.Public.class)
    private String companyName;

    @NotEmpty
    @Length(min = 1, max = 100)
    @JsonView(View.Public.class)
    private String contactPerson;

    @NotEmpty
    @Length(min = 1, max = 100)
    @JsonView(View.Public.class)
    private String phoneNumber;

    @NotEmpty
    @Email
    @JsonView(View.Public.class)
    private String email;

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

    public int getCompanyAddressID() {
        return companyAddressID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
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

    public void setId(int id) {
        this.id = id;
    }

    public void setCompanyAddressID(int companyAddressID) {
        this.companyAddressID = companyAddressID;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getNoteText() {
        return noteText;
    }

    public void setNoteText(String noteText) {
        this.noteText = noteText;
    }
}
