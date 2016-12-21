package Server.Model;

/**
 * Created by Roel on 13-12-2016.
 */
public class Note {
    private int id;
    private int ownerID;
    private String text;

    public Note(){

    }

    public Note(int id, int ownerID, String text) {
        this.id = id;
        this.ownerID = ownerID;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(int ownerID) {
        this.ownerID = ownerID;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
