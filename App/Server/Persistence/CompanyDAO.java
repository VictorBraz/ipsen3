package Server.Persistence;

import Server.Model.Address;
import Server.Model.Company;
import Server.Model.Note;
import com.google.inject.Singleton;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mitch on 12/9/2016.
 * @author Bernd
 */


public class CompanyDAO extends DatabaseDAO {

    private AddressDAO addressDAO;
    private NoteDAO noteDAO;
    private PreparedStatement getCompany;
    private PreparedStatement addCompany;
    private PreparedStatement getAll;
    private PreparedStatement updateCompany;


    public CompanyDAO() throws Exception {
        super();
        prepareStatements();
        this.addressDAO =  new AddressDAO();
        this.noteDAO = new NoteDAO();

    }

    private void prepareStatements() {
        try {
            getCompany = conn.prepareStatement("SELECT * FROM company WHERE id =?");
            addCompany = conn.prepareStatement("INSERT INTO company (companyaddressid, companyname, contactperson," +
                    "phonenumber, email, tag ) VALUES (?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
            getAll = conn.prepareStatement("SELECT * FROM company");
            updateCompany = conn.prepareStatement("UPDATE company SET companyaddressid=?, companyname=?, contactperson=?," +
                    "phonenumber=?, email=?, tag=? WHERE id =?");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addCompany(Company company) {
        Address address = new Address();
        address.setAddress(company.getAddress());
        address.setCity(company.getCity());
        address.setPostcode(company.getPostcode());

        Note note = new Note();
        note.setText(company.getNoteText());

        company.setCompanyAddressID(addressDAO.addAddress(address).getId());

        try {
            addCompany.setInt(1, company.getCompanyAddressID());
            addCompany.setString(2, company.getCompanyName());
            addCompany.setString(3, company.getContactPerson());
            addCompany.setString(4, company.getPhoneNumber());
            addCompany.setString(5, company.getEmail());
            addCompany.setString(6, company.getTag());


            addCompany.executeUpdate();

            ResultSet rs = addCompany.getGeneratedKeys();
            while (rs.next()){
                company.setId(rs.getInt("id"));
            }

            note.setOwnerID(company.getId());
            noteDAO.addNote(note);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List <Company> getAll() {
        List<Company> companies = new ArrayList<>();

        try {
            ResultSet result =getAll.executeQuery();

            while (result.next()) {
                Company company = new Company();
                company.setId(result.getInt(1));
                company.setCompanyAddressID(result.getInt(2));
                company.setCompanyName(result.getString(3));
                company.setContactPerson(result.getString(4));
                company.setPhoneNumber(result.getString(5));
                company.setEmail(result.getString(6));
                company.setTag(result.getString(7));
                company.setActive(result.getBoolean(8));

                Address address = addressDAO.getAddress(result.getInt(2));
                company.setAddress(address.getAddress());
                company.setCity(address.getCity());
                company.setPostcode(address.getPostcode());

                Note note = noteDAO.getNote(company.getId());
                company.setNoteText(note.getText());

                companies.add(company);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return companies;
    }

    public Company getCompany(int id) {
        Company company = new Company();

        try {
            getCompany.setInt(1, id);
            ResultSet result = getCompany.executeQuery();

            while (result.next()) {
                company.setId(result.getInt(1));
                company.setCompanyAddressID(result.getInt(2));
                company.setCompanyName(result.getString(3));
                company.setContactPerson(result.getString(4));
                company.setPhoneNumber(result.getString(5));
                company.setEmail(result.getString(6));
                company.setTag(result.getString(7));

                Address address = addressDAO.getAddress(company.getCompanyAddressID());
                company.setAddress(address.getAddress());
                company.setCity(address.getCity());
                company.setPostcode(address.getPostcode());

                Note note = noteDAO.getNote(company.getId());
                company.setNoteText(note.getText());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return company;

    }

    public void update(Company company) {
        Address address = new Address();
        address.setAddress(company.getAddress());
        address.setCity(company.getCity());
        address.setPostcode(company.getPostcode());
        address.setId(company.getCompanyAddressID());

        addressDAO.UpdateAddress(address);

        Note note = new Note();
        note.setText(company.getNoteText());
        note.setOwnerID(company.getId());

        noteDAO.update(note);

        try {
            updateCompany.setInt(1, company.getCompanyAddressID());
            updateCompany.setString(2, company.getCompanyName());
            updateCompany.setString(3, company.getContactPerson());
            updateCompany.setString(4, company.getPhoneNumber());
            updateCompany.setString(5, company.getEmail());
            updateCompany.setString(6, company.getTag());

            updateCompany.setInt(7, company.getId());
            updateCompany.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}