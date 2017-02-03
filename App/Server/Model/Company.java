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
 * The type Company.
 *
 * @author Bernd, Mitch
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

    @JsonView(View.Public.class)
    private Boolean active;

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Gets company address id.
     *
     * @return the company address id
     */
    public int getCompanyAddressID() {
        return companyAddressID;
    }

    /**
     * Gets company name.
     *
     * @return the company name
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * Gets contact person.
     *
     * @return the contact person
     */
    public String getContactPerson() {
        return contactPerson;
    }

    /**
     * Gets phone number.
     *
     * @return the phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Gets tag.
     *
     * @return the tag
     */
    public String getTag() {
        return tag;
    }

    /**
     * Gets address.
     *
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Gets city.
     *
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * Gets postcode.
     *
     * @return the postcode
     */
    public String getPostcode() {
        return postcode;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Sets company address id.
     *
     * @param companyAddressID the company address id
     */
    public void setCompanyAddressID(int companyAddressID) {
        this.companyAddressID = companyAddressID;
    }

    /**
     * Sets company name.
     *
     * @param companyName the company name
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * Sets contact person.
     *
     * @param contactPerson the contact person
     */
    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    /**
     * Sets phone number.
     *
     * @param phoneNumber the phone number
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Sets tag.
     *
     * @param tag the tag
     */
    public void setTag(String tag) {
        this.tag = tag;
    }

    /**
     * Sets address.
     *
     * @param address the address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Sets city.
     *
     * @param city the city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Sets postcode.
     *
     * @param postcode the postcode
     */
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    /**
     * Gets note text.
     *
     * @return the note text
     */
    public String getNoteText() {
        return noteText;
    }

    /**
     * Sets note text.
     *
     * @param noteText the note text
     */
    public void setNoteText(String noteText) {
        this.noteText = noteText;
    }

    /**
     * Gets active.
     *
     * @return the active
     */
    public Boolean getActive() {
        return active;
    }

    /**
     * Sets active.
     *
     * @param active the active
     */
    public void setActive(Boolean active) {
        this.active = active;
    }
}
