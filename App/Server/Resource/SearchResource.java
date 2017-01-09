package Server.Resource;

/**
 * Created by Braz on 09/01/2017.
 */

import Server.Model.Client;
import Server.Model.Company;
import Server.Model.Employee;
import Server.Service.ClientService;
import Server.Service.CompanyService;
import Server.Service.EmployeeService;
import Server.View;
import com.fasterxml.jackson.annotation.JsonView;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.sun.tools.javac.util.*;

import javax.annotation.security.PermitAll;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.*;
import java.util.List;

@Singleton
@Path("/search")
@Produces(MediaType.APPLICATION_JSON)
public class SearchResource {

    private final ClientService clientService;
    private final CompanyService companyService;
    private final EmployeeService employeeService;

    @Inject
    public SearchResource(ClientService cs, CompanyService comp, EmployeeService emp){
        this.companyService = comp;
        this.clientService = cs;
        this.employeeService = emp;
    }

    @GET
    @Path("/{tag}")
    @JsonView(View.Public.class)
    @PermitAll
    public Collection<Collection> retrieve(@PathParam("tag") String tag){

        List<Collection> list = new List<Collection>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<Collection> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(Collection collection) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends Collection> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, Collection<? extends Collection> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public Collection get(int index) {
                return null;
            }

            @Override
            public Collection set(int index, Collection element) {
                return null;
            }

            @Override
            public void add(int index, Collection element) {

            }

            @Override
            public Collection remove(int index) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<Collection> listIterator() {
                return null;
            }

            @Override
            public ListIterator<Collection> listIterator(int index) {
                return null;
            }

            @Override
            public List<Collection> subList(int fromIndex, int toIndex) {
                return null;
            }
        };

        Collection<Client> clients = clientService.getAll();
        Collection<Company> companies = companyService.getAll();
        Collection<Employee> employees = employeeService.getAll();

        for(Client client : clients){
            if(!client.getTag().contains(tag)){
                clients.remove(client);
            }
        }
        list.add(clients);

        for (Company company : companies){
            if(!company.getTag().contains(tag)){
                companies.remove(company);
            }
        }
        list.add(companies);

        for (Employee employee : employees){
            if(!employee.getTag().contains(tag)){
                employees.remove(employee);
            }
        }
        list.add(employees);

        return list;

    }
}
