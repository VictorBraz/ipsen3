package Server.Persistence;

import Server.Model.Calender;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vedadpiric on 19-01-17.
 */
public class CalenderDAO extends DatabaseDAO {
    private PreparedStatement getEvent;
    private PreparedStatement addEvent;
    private PreparedStatement updateEvent;
    private PreparedStatement deleteEvent;
    private PreparedStatement getAll;

    /**
     * Instantiates a new Calender dao.
     *
     * @throws Exception the exception
     */
    public CalenderDAO() throws Exception {
        super();
        prepareStatements();
    }

    private void prepareStatements() {
        try {
            getAll = conn.prepareStatement("SELECT * FROM calender ");
            getEvent = conn.prepareStatement("SELECT * FROM calender WHERE id=?");
            addEvent = conn.prepareStatement("INSERT INTO calender (eventname,datum,aangemaaktdoor) VALUES (?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
            updateEvent = conn.prepareStatement("UPDATE calender SET eventname = ? , datum = ? ,aangemaaktdoor = ? WHERE id = ?");
            deleteEvent = conn.prepareStatement("DELETE FROM calender WHERE id =?");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Get event calender.
     *
     * @param id the id
     * @return the calender
     */
    public Calender getEVENT(int id) {
        Calender calender = new Calender();
        try {
            getEvent.setInt(1, id);
            ResultSet rs = getEvent.executeQuery();

            while (rs.next()) {
                calender.setEventName(rs.getString(1));
                calender.setDatum(rs.getDate(2));
                calender.setContactPersoon(rs.getString(3));
                calender.setId(rs.getInt(4));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return calender;

    }

    /**
     * Get all list.
     *
     * @return the list
     */
    public List<Calender> getAll() {
        List<Calender> calenderList = new ArrayList<>();
        try {
            ResultSet rs = getAll.executeQuery();

            while (rs.next()) {
                Calender calender = new Calender();
                calender.setId(rs.getInt(4));
                calender.setEventName(rs.getString(1));
                calender.setDatum(rs.getDate(2));
                calender.setContactPersoon(rs.getString(3));

                calenderList.add(calender);


            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return calenderList;
    }


    /**
     * Add events calender.
     *
     * @param calender the calender
     * @return the calender
     */
    public Calender addEvents(Calender calender) {

        java.util.Date util_StartDate = calender.getDatum();
        java.sql.Date sql_StartDate = new java.sql.Date(util_StartDate.getTime());
        try {
            addEvent.setString(1, calender.getEventName());
            addEvent.setDate(2, sql_StartDate);
            addEvent.setString(3, calender.getContactPersoon());
            addEvent.executeUpdate();
            addEvent.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return calender;
    }

    /**
     * Update events.
     *
     * @param calender the calender
     */
    public void UpdateEvents(Calender calender) {
        java.util.Date util_StartDate = calender.getDatum();
        java.sql.Date sql_StartDate = new java.sql.Date(util_StartDate.getTime());

        try {

            updateEvent.setString(1, calender.getEventName());
            updateEvent.setDate(2, sql_StartDate);
            updateEvent.setString(3, calender.getContactPersoon());
            updateEvent.setInt(4, calender.getId());
            updateEvent.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Delete event.
     *
     * @param id the id
     */
    public void deleteEvent(int id) {
        try {

            deleteEvent.setInt(1, id);
            deleteEvent.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}
