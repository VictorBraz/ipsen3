package Server.Model;

import Server.View;
import com.fasterxml.jackson.annotation.JsonView;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by Negin Nafissi on 13-12-2016.
 *
 * @author Negin, Roel
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
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets employee address id.
     *
     * @return the employee address id
     */
    public int getEmployeeAddressID() {
        return employeeAddressID;
    }

    /**
     * Sets employee address id.
     *
     * @param employeeAddressID the employee address id
     */
    public void setEmployeeAddressID(int employeeAddressID) {
        this.employeeAddressID = employeeAddressID;
    }

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets birth date.
     *
     * @return the birth date
     */
    public String getBirthDate() {
        return birthDate;
    }

    /**
     * Sets birth date.
     *
     * @param birthDate the birth date
     */
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * Gets study.
     *
     * @return the study
     */
    public String getStudy() {
        return study;
    }

    /**
     * Sets study.
     *
     * @param study the study
     */
    public void setStudy(String study) {
        this.study = study;
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
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
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
     * Sets phone number.
     *
     * @param phoneNumber the phone number
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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
     * Sets tag.
     *
     * @param tag the tag
     */
    public void setTag(String tag) {
        this.tag = tag;
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
     * Sets address.
     *
     * @param address the address
     */
    public void setAddress(String address) {
        this.address = address;
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
     * Sets city.
     *
     * @param city the city
     */
    public void setCity(String city) {
        this.city = city;
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
     * Sets active.
     *
     * @param active the active
     */
    public void setActive(Boolean active) {
        this.active = active;
    }

    /**
     * Gets active.
     *
     * @return the active
     */
    public Boolean getActive() {
        return active;
    }
}
