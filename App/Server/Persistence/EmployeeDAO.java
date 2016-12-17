package Server.Persistence;

import Server.Model.Employee;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Negin on 13-12-2016.
 */
public class EmployeeDAO extends DatabaseDAO {

    private AddressDAO addressDAO;
    private PreparedStatement getEmployee;
    private PreparedStatement addEmployee;
    private PreparedStatement getAll;

    public EmployeeDAO() throws Exception {
        super();
        prepareStatements();
        try {
            this.addressDAO = new AddressDAO();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void prepareStatements() {
        try {
            getEmployee = conn.prepareStatement("SELECT * FROM student WHERE id=?");
            addEmployee = conn.prepareStatement("INSERT INTO student (studentaddressid, firstName, lastName, birthDate, study, email, phoneNumber, tag) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            getAll = conn.prepareStatement("SELECT * FROM student");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void addEmployee(Employee employee){
        try {
            addEmployee.setInt(1, employee.getEmployeeAddressID());
            addEmployee.setString(2, employee.getFirstName());
            addEmployee.setString(3, employee.getLastName());
            addEmployee.setString(4, employee.getBirthDate());
            addEmployee.setString(5, employee.getStudy());
            addEmployee.setString(6, employee.getEmail());
            addEmployee.setString(7, employee.getPhoneNumber());
            addEmployee.setString(8, employee.getTag());

            addEmployee.executeUpdate();
//            addEmployee.close();
        }catch (Exception e){
        }
    }

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
                employees.add(employee);
            }
//            getAll.close();
        }catch (Exception e) {
        }

        return employees;
    }

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
            }
//            getEmployee.close();
        }catch (Exception e){
        }
        return employee;
    }
}
