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
    public Collection<Calender> getAll(){
        return dao.getAll();
    }
    public Calender get(int id){
        return dao.getEVENT(id);
    }
    public void add(Calender calender){
        dao.addEvents(calender);
    }
    public void update(Calender calender) {
        dao.UpdateEvents(calender);
    }
    public void delete(int id) {
        dao.deleteEvent(id);
    }

}

