package Server.Model;

/**
 * Datamodel is voor het ophalen van documenten
 *
 * @author Vedad Piric
 * @version 1.0
 * @since 3/02/2016
 */
public class Document {
    String documentname;

    /**
     * Haalt documentnaam op
     *
     * @return document naam
     */
    public String getDocumentname() {
        return documentname;
    }

    /**
     * Set een document naam
     */
    public void setDocumentname(String documentname) {
        this.documentname = documentname;
    }


}
