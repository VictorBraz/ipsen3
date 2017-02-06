package Server.Persistence;

import Server.Model.Document;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by vedadpiric on 05-02-17.
 */
public class DocumentDAO extends DatabaseDAO {

    private PreparedStatement bestandSelecteren;
    private PreparedStatement bestandToeveogen;
    private PreparedStatement bestandBewerken;

    private String bestandSelecterenQuery = "SELECT documentname,pdffile FROM document WHERE ownerid = ?;";
    private String bestandToeveogenQuery = "INSERT INTO document(ownerid,documentname, pdffile) VALUES (?,?,?)";
    private String bestandVerwijderenQuery = "DELETE FROM document WHERE id = ?";


    /**
     * Instantiates a new Document dao.
     *
     * @throws Exception the exception
     */
    public DocumentDAO() throws Exception{
        super();
        prepareStatements();

    }

    private void prepareStatements() {
        try {
            bestandSelecteren = conn.prepareStatement(bestandSelecterenQuery);
            bestandToeveogen = conn.prepareStatement(bestandToeveogenQuery);
            bestandBewerken = conn.prepareStatement(bestandVerwijderenQuery);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets file.
     *
     * @param id       the id
     * @param filename the filename
     * @return the file
     */
    public String getFile(int id,String filename) {

        byte[] fileBytes;
        File file = new File(filename);
        String fileDownloadLink = "http://localhost:8080/fileToDownload/"+file;
        String filePath ="/Users/vedadpiric/ipsen3/App/filesToDownload/"+file;
        try {
            bestandSelecteren.setInt(1, id);

            ResultSet rs = bestandSelecteren.executeQuery();
            if (rs.next()) {

                fileBytes = rs.getBytes("pdffile");

                FileOutputStream targetFile = new FileOutputStream(filePath);
                targetFile.write(fileBytes);
                targetFile.close();

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return fileDownloadLink;
    }

    /**
     * Gets all documents.
     *
     * @param id the id
     * @return the all documents
     */
    public ArrayList<Document> getAllDocuments(int id) {
        ArrayList<Document> documentLijst = new ArrayList<Document>();
        Document document;
        try {
            bestandSelecteren.setInt(1, id);
            ResultSet set = bestandSelecteren.executeQuery();
            while (set.next()) {
                document = new Document();

                document.setDocumentname(set.getString("documentname"));
                documentLijst.add(document);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (documentLijst);
    }
}