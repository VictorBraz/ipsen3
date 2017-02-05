package Server.Model;


import Server.View;
import com.fasterxml.jackson.annotation.JsonView;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * The type Client.
 *
 * @author Victor Machado Braz, Roel
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

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Gets client addres id.
     *
     * @return the client addres id
     */
    public int getClientAddresId() {
        return clientAddresId;
    }

    /**
     * Gets firstname.
     *
     * @return the firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * Gets lastname.
     *
     * @return the lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Gets birthdate.
     *
     * @return the birthdate
     */
    public String getBirthdate() {
        return birthdate;
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
     * Gets email address.
     *
     * @return the email address
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Gets phonenumber.
     *
     * @return the phonenumber
     */
    public String getPhonenumber() {
        return phonenumber;
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
     * Gets note text.
     *
     * @return the note text
     */
    public String getNoteText() {
        return noteText;
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
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Sets client addres id.
     *
     * @param clientAddresId the client addres id
     */
    public void setClientAddresId(int clientAddresId) {
        this.clientAddresId = clientAddresId;
    }

    /**
     * Sets firstname.
     *
     * @param firstname the firstname
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * Sets lastname.
     *
     * @param lastname the lastname
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * Sets birthdate.
     *
     * @param birthdate the birthdate
     */
    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
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
     * Sets email address.
     *
     * @param emailAddress the email address
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * Sets phonenumber.
     *
     * @param phonenumber the phonenumber
     */
    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
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
}
