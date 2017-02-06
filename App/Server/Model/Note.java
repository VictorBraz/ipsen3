package Server.Model;

/**
 * Created by Roel on 13-12-2016.
 */
public class Note {
    private int id;
    private int ownerID;
    private String text;

    /**
     * Instantiates a new Note.
     */
    public Note() {

    }

    /**
     * Instantiates a new Note.
     *
     * @param id      the id
     * @param ownerID the owner id
     * @param text    the text
     */
    public Note(int id, int ownerID, String text) {
        this.id = id;
        this.ownerID = ownerID;
        this.text = text;
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
     * Gets owner id.
     *
     * @return the owner id
     */
    public int getOwnerID() {
        return ownerID;
    }

    /**
     * Sets owner id.
     *
     * @param ownerID the owner id
     */
    public void setOwnerID(int ownerID) {
        this.ownerID = ownerID;
    }

    /**
     * Gets text.
     *
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * Sets text.
     *
     * @param text the text
     */
    public void setText(String text) {
        this.text = text;
    }
}
