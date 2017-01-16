package Server.Service;

import Server.Model.Employee;
import Server.Persistence.EmployeeDAO;

import javax.inject.Inject;
import java.util.Collection;

/**
 * Created by Negin on 13-12-2016.
 */
public class EmployeeService extends BaseService<Employee> {

    private final EmployeeDAO dao;

    @Inject
    public EmployeeService(EmployeeDAO dao){
        this.dao = dao;
    }
    public Collection<Employee> getAll(){
        return dao.getAll();
    }
    public Employee get(int id){
        return dao.getEmployee(id);
    }
    public void add(Employee employee){
        dao.addEmployee(employee);
    }
    public void update(Employee employee) {
        dao.update(employee);
    }


}
