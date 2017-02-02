package Server.Model;

import Server.View;
import com.fasterxml.jackson.annotation.JsonView;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.Date;

/**
 * Created by vedadpiric on 19-01-17.
 */
public class Calender {


    @NotEmpty
    @JsonView(View.Public.class)
    private int id;

    @NotEmpty
    @Length(min = 1, max = 100)
    @JsonView(View.Public.class)
    private Date datum;


    @NotEmpty
    @Length(min = 1, max = 100)
    @JsonView(View.Public.class)
    private String eventName;



    @NotEmpty
    @Length(min = 1, max = 100)
    @JsonView(View.Public.class)
    private String contactPersoon;



    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getContactPersoon() {
        return contactPersoon;
    }
    public void setContactPersoon(String contactPersoon) {this.contactPersoon = contactPersoon; }
}
