package Server.Service;

import Server.Model.Note;
import Server.Persistence.NoteDAO;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import java.util.List;

/**
 * Created by Roel on 15-12-2016.
 */
@Singleton
public class NoteService extends BaseService<Note>{

    private final NoteDAO dao;

    @Inject
    public NoteService(NoteDAO dao){
        this.dao = dao;
    }
    public Note get(int id){
        return dao.getNote(id);
    }
    public void add(Note note){
        dao.addNote(note);
    }
    public void edit(Note note){
        dao.editNote(note);
    }
    public List<Note>getAll(){
        System.out.println("Get all Notes");
        return dao.getAll();}
}
