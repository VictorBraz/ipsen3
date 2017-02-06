package Server.Model;

import Server.View;
import com.fasterxml.jackson.annotation.JsonView;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.Date;

/**
 * Created by vedadpiric on 19-01-17.
 */
public class Calender {


    @NotEmpty
    @JsonView(View.Public.class)
    private int id;

    @JsonView(View.Public.class)
    private Date datum;

    @JsonView(View.Public.class)
    private String eventName;

    @JsonView(View.Public.class)
    private String contactPersoon;


    /**
     * Gets event name.
     *
     * @return the event name
     */
    public String getEventName() {
        return eventName;
    }

    /**
     * Sets event name.
     *
     * @param eventName the event name
     */
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    /**
     * Gets datum.
     *
     * @return the datum
     */
    public Date getDatum() {
        return datum;
    }

    /**
     * Sets datum.
     *
     * @param datum the datum
     */
    public void setDatum(Date datum) {
        this.datum = datum;
    }

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
     * Gets contact persoon.
     *
     * @return the contact persoon
     */
    public String getContactPersoon() {
        return contactPersoon;
    }

    /**
     * Sets contact persoon.
     *
     * @param contactPersoon the contact persoon
     */
    public void setContactPersoon(String contactPersoon) {this.contactPersoon = contactPersoon; }
}
