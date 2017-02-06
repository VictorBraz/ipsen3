package Server.Model;

/**
 * Datamodel is voor het ophalen van documenten
 * @author  Vedad Piric
 * @version 1.0
 * @since   3/02/2016
 */
public class Document {
    String Document_Titel;

    /**
     * Haalt documentnaam op
     * @return  document naam
     */
    public String getDocument_Titel() {
        return Document_Titel;
    }

    /**
     * Set een document naam
     *
     */
    public void setDocument_Titel(String document_Titel) {
        Document_Titel = document_Titel;
    }



}
