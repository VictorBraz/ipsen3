package Server.Service;

import Server.Model.Employee;
import Server.Persistence.EmployeeDAO;

import javax.inject.Inject;
import java.util.Collection;

/**
 * Created by Negin Nafissi on 13-12-2016.
 */
public class EmployeeService extends BaseService<Employee> {

    private final EmployeeDAO dao;

    /**
     * Instantiates a new Employee service.
     *
     * @param dao the dao
     */
    @Inject
    public EmployeeService(EmployeeDAO dao){
        this.dao = dao;
    }

    /**
     * Get all collection.
     *
     * @return the collection
     */
    public Collection<Employee> getAll(){
        return dao.getAll();
    }

    /**
     * Get employee.
     *
     * @param id the id
     * @return the employee
     */
    public Employee get(int id){
        return dao.getEmployee(id);
    }

    /**
     * Add.
     *
     * @param employee the employee
     */
    public void add(Employee employee){
        dao.addEmployee(employee);
    }

    /**
     * Update.
     *
     * @param employee the employee
     */
    public void update(Employee employee) {
        dao.update(employee);
    }

    /**
     * Delete.
     *
     * @param id the id
     */
    public void delete(int id) {
        dao.delete(id);
    }


}
