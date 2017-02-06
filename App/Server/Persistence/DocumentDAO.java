package Server.Persistence;

import Server.Model.Client;
import Server.Model.Document;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    public void fileInsert(Client client, File file) throws FileNotFoundException {

        int len = (int) file.length();
        try {

            FileInputStream fis = new FileInputStream(file.getPath());
            bestandToeveogen.setInt(1, client.getId());
            bestandToeveogen.setString(2, file.getName());
            bestandToeveogen.setBinaryStream(3, fis, len);
            bestandToeveogen.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void getFile(Client client, File file) {

        byte[] fileBytes;


        try {
            bestandSelecteren.setInt(1, client.getId());
            ResultSet rs = bestandSelecteren.executeQuery();
            if (rs.next()) {

                fileBytes = rs.getBytes("pdffile");

                FileOutputStream targetFile = new FileOutputStream(file);
                targetFile.write(fileBytes);
                targetFile.close();

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

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