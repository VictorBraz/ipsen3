package Server.Persistence;

import Server.Model.Note;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Roel on 13-12-2016.
 */
public class NoteDAO extends DatabaseDAO {

    private PreparedStatement addNote;
    private PreparedStatement getNote;
    private PreparedStatement editNote;
    private PreparedStatement getAll;


    /**
     * Instantiates a new Note dao.
     *
     * @throws Exception the exception
     */
    public NoteDAO() throws Exception {

        super();

        prepareStatements();
    }

    /**
     * Prepare statements.
     */
    public void prepareStatements() {

        try {
            addNote = conn.prepareStatement("INSERT INTO note(note,ownerID) VALUES(?,?)");
            getNote = conn.prepareStatement("SELECT * FROM note WHERE ownerID=?");
            editNote = conn.prepareStatement("UPDATE note SET note=? WHERE ownerID=?");
            getAll = conn.prepareStatement("SELECT*FROM note");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Add note.
     *
     * @param note the note
     */
    public void addNote(Note note) {

        try {
            if (note.getText() == null) {
                note.setText("");
            }
            addNote.setString(1, note.getText());
            addNote.setInt(2, note.getOwnerID());

            addNote.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get note note.
     *
     * @param ownerID the owner id
     * @return the note
     */
    public Note getNote(int ownerID) {
        Note note = new Note();
        try {
            getNote.setInt(1, ownerID);
            ResultSet rs = getNote.executeQuery();

            while (rs.next()) {
                note.setId(rs.getInt(1));
                note.setText(rs.getString(2));
                note.setOwnerID(rs.getInt(3));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return note;
    }

    /**
     * Update.
     *
     * @param note the note
     */
    public void update(Note note) {

        try {
            editNote.setString(1, note.getText());
            editNote.setInt(2, note.getOwnerID());

            editNote.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get all list.
     *
     * @return the list
     */
    public List<Note> getAll() {

        List<Note> notes = new ArrayList<>();

        try {
            ResultSet rs = getAll.executeQuery();

            while (rs.next()) {
                Note note = new Note();
                note.setId(rs.getInt(1));
                note.setText(rs.getString(2));
                note.setOwnerID(rs.getInt(3));
                notes.add(note);
            }
            getAll.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return notes;
    }

    /**
     * Close.
     */
    public void close() {

        try {
            addNote.close();
            getNote.close();
            editNote.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
