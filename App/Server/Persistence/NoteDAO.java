package Server.Persistence;

import Server.Model.Note;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Roel on 13-12-2016.
 */
public class NoteDAO extends DatabaseDAO {
    private PreparedStatement addNote;
    private PreparedStatement getNote;
    private PreparedStatement editNote;

    public NoteDAO() throws Exception {
        super();
        prepareStatements();
    }

    public void prepareStatements(){
        try {
            addNote = conn.prepareStatement("INSERT INTO note(note,ownerID) VALUES(?,?)");
            getNote = conn.prepareStatement("SELECT * FROM note WHERE ownerID=?");
            editNote = conn.prepareStatement("UPDATE note SET note=? WHERE ownerID=?");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void addNote(Note note){
        try {
            addNote.setString(1,note.getText());
            addNote.setInt(2,note.getOwnerID());

            addNote.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public Note getNote(int ownerID){
        Note note = new Note();
        try {
            getNote.setInt(1,ownerID);
            ResultSet rs = getNote.executeQuery();

            while(rs.next()){
                note.setId(rs.getInt(1));
                note.setText(rs.getString(2));
                note.setOwnerID(rs.getInt(3));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return note;
    }

    public void editNote(Note note){
        try {
            editNote.setString(1,note.getText());
            editNote.setInt(2,note.getOwnerID());

            editNote.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void close(){
        try {
            addNote.close();
            getNote.close();
            editNote.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

}
