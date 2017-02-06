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

    /**
     * Instantiates a new Note service.
     *
     * @param dao the dao
     */
    @Inject
    public NoteService(NoteDAO dao){
        this.dao = dao;
    }

    /**
     * Get note.
     *
     * @param id the id
     * @return the note
     */
    public Note get(int id){
        return dao.getNote(id);
    }

    /**
     * Add.
     *
     * @param note the note
     */
    public void add(Note note){
        dao.addNote(note);
    }

    /**
     * Update.
     *
     * @param note the note
     */
    public void update(Note note){
        dao.update(note);
    }

    /**
     * Get all list.
     *
     * @return the list
     */
    public List<Note>getAll(){ return dao.getAll();}
}
