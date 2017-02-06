package Server.Service;

import Server.Model.Calender;
import Server.Persistence.CalenderDAO;

import javax.inject.Inject;
import java.util.Collection;

/**
 * Created by vedadpiric on 23-01-17.
 */
public class CalenderService  extends BaseService<Calender>{

    private final CalenderDAO dao;

    @Inject
    private CalenderService(CalenderDAO dao){
        this.dao = dao;
    }

    /**
     * Get all collection.
     *
     * @return the collection
     */
    public Collection<Calender> getAll(){
        return dao.getAll();
    }

    /**
     * Get calender.
     *
     * @param id the id
     * @return the calender
     */
    public Calender get(int id){
        return dao.getEVENT(id);
    }

    /**
     * Add.
     *
     * @param calender the calender
     */
    public void add(Calender calender){
        dao.addEvents(calender);
    }

    /**
     * Update.
     *
     * @param calender the calender
     */
    public void update(Calender calender) {
        dao.UpdateEvents(calender);
    }

    /**
     * Delete.
     *
     * @param id the id
     */
    public void delete(int id) {
        dao.deleteEvent(id);
    }

}

