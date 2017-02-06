package Server.Persistence;

import Server.Model.Address;
import Server.Model.Employee;
import Server.Model.Note;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Negin Nafissi on 13-12-2016.
 * @author Negin, Roel
 *
 */
public class EmployeeDAO extends DatabaseDAO {

    private AddressDAO addressDAO;
    private NoteDAO noteDAO;
    private PreparedStatement getEmployee;
    private PreparedStatement addEmployee;
    private PreparedStatement updateEmployee;
    private PreparedStatement deleteEmployee;
    private PreparedStatement getAll;


    /**
     * Instantiates a new Employee dao.
     *
     * @throws Exception the exception
     */
    public EmployeeDAO() throws Exception {
        super();
        prepareStatements();
        this.addressDAO = new AddressDAO();
        this.noteDAO = new NoteDAO();
    }

    private void prepareStatements() {
        try {
            getEmployee = conn.prepareStatement("SELECT * FROM student WHERE id=?");
            addEmployee = conn.prepareStatement("INSERT INTO student (studentaddressid, firstName, lastName," +
                    " birthDate, study, email, phoneNumber, tag) VALUES (?, ?, ?, ?, ?, ?, ?, ?)",
                    PreparedStatement.RETURN_GENERATED_KEYS);
            getAll = conn.prepareStatement("SELECT * FROM student");
            updateEmployee = conn.prepareStatement("UPDATE student SET studentaddressid=?, firstname=?," +
                    " lastname=?, birthdate=?, study=?, email=?, phonenumber=?, tag=? WHERE id=?");
            deleteEmployee = conn.prepareStatement("UPDATE student SET active=? WHERE id =?");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * Add employee.
     *
     * @param employee the employee
     */
    public void addEmployee(Employee employee){
        try {
            Address address = new Address();
            address.setAddress(employee.getAddress());
            address.setCity(employee.getCity());
            address.setPostcode(employee.getPostcode());

            employee.setEmployeeAddressID(addressDAO.addAddress(address).getId());

            addEmployee.setInt(1, employee.getEmployeeAddressID());
            addEmployee.setString(2, employee.getFirstName());
            addEmployee.setString(3, employee.getLastName());
            addEmployee.setString(4, employee.getBirthDate());
            addEmployee.setString(5, employee.getStudy());
            addEmployee.setString(6, employee.getEmail());
            addEmployee.setString(7, employee.getPhoneNumber());
            addEmployee.setString(8, employee.getTag());

            addEmployee.executeUpdate();

            ResultSet rs = addEmployee.getGeneratedKeys();
            if (rs.next()){
                employee.setId(rs.getInt("id"));
            }

            Note note = new Note();
            note.setOwnerID(employee.getId());
            note.setText(employee.getNoteText());
            noteDAO.addNote(note);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Get all list.
     *
     * @return the list
     */
    public List<Employee> getAll(){
        List<Employee> employees = new ArrayList<>();
        try{
            ResultSet rs = getAll.executeQuery();

            while (rs.next()){
                Employee employee = new Employee();

                employee.setId(rs.getInt(1));
                employee.setEmployeeAddressID(rs.getInt(2));
                employee.setFirstName(rs.getString(3));
                employee.setLastName(rs.getString(4));
                employee.setBirthDate(rs.getString(5));
                employee.setStudy(rs.getString(6));
                employee.setEmail(rs.getString(7));
                employee.setPhoneNumber(rs.getString(8));
                employee.setTag(rs.getString(9));
                employee.setActive(rs.getBoolean(10));

                Address address = addressDAO.getAddress(rs.getInt(2));
                employee.setAddress(address.getAddress());
                employee.setCity(address.getCity());
                employee.setPostcode(address.getPostcode());

                Note note = noteDAO.getNote(employee.getId());
                employee.setNoteText(note.getText());

                employees.add(employee);
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
        return employees;
    }

    /**
     * Gets employee.
     *
     * @param id the id
     * @return the employee
     */
    public Employee getEmployee(int id) {
        Employee employee = new Employee();
        try {
            getEmployee.setInt(1, id);
            ResultSet rs = getEmployee.executeQuery();

            while (rs.next()) {
                employee.setId(rs.getInt(1));
                employee.setEmployeeAddressID(rs.getInt(2));
                employee.setFirstName(rs.getString(3));
                employee.setLastName(rs.getString(4));
                employee.setBirthDate(rs.getString(5));
                employee.setStudy(rs.getString(6));
                employee.setEmail(rs.getString(7));
                employee.setPhoneNumber(rs.getString(8));
                employee.setTag(rs.getString(9));
                employee.setActive(rs.getBoolean(10));


                Address address = addressDAO.getAddress(employee.getEmployeeAddressID());
                employee.setAddress(address.getAddress());
                employee.setCity(address.getCity());
                employee.setPostcode(address.getPostcode());

                Note note = noteDAO.getNote(employee.getId());
                employee.setNoteText(note.getText());

            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return employee;
    }

    /**
     * Update.
     *
     * @param employee the employee
     */
    public void update(Employee employee){
        Address address = new Address();
        address.setAddress(employee.getAddress());
        address.setCity(employee.getCity());
        address.setPostcode(employee.getPostcode());
        address.setId(employee.getEmployeeAddressID());

        Note note = new Note();
        note.setText(employee.getNoteText());
        note.setOwnerID(employee.getId());

        try {

            addressDAO.UpdateAddress(address);

            noteDAO.update(note);

            updateEmployee.setInt(1, employee.getEmployeeAddressID());
            updateEmployee.setString(2, employee.getFirstName());
            updateEmployee.setString(3, employee.getLastName());
            updateEmployee.setString(4, employee.getBirthDate());
            updateEmployee.setString(5, employee.getStudy());
            updateEmployee.setString(6, employee.getEmail());
            updateEmployee.setString(7, employee.getPhoneNumber());
            updateEmployee.setString(8, employee.getTag());
            updateEmployee.setInt(9, employee.getId());

            updateEmployee.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Delete.
     *
     * @param id the id
     */
    public void delete (int id) {
        try {
            if (getEmployee(id).getActive() == true) {
                deleteEmployee.setBoolean(1, false);
                deleteEmployee.setInt(2, id);
                deleteEmployee.execute();

            } else {
                deleteEmployee.setBoolean(1, true);
                deleteEmployee.setInt(2, id);
                deleteEmployee.execute();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
