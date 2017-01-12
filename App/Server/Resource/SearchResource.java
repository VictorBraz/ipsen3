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

import javax.annotation.security.PermitAll;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Collection;
import java.util.Iterator;

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
    @Path("/clients/{tag}")
    @JsonView(View.Public.class)
    @PermitAll
    public Collection<Client> retrieveClients(@PathParam("tag") @JsonView String tag) throws Exception {

        Collection<Client> clients = clientService.getAll();
        System.out.println("RETRIEVECLIENTS");
        for (Iterator<Client> clientIterator = clients.iterator(); clientIterator.hasNext(); ) {
            Client client = clientIterator.next();
            if (!client.getTag().toLowerCase().contains(tag.toLowerCase())) {
                clientIterator.remove();
            }
        }
        return clients;
    }

    @GET
    @Path("/companies/{tag}")
    @JsonView(View.Public.class)
    @PermitAll
    public Collection<Company> retrieveCompanies(@PathParam("tag") @JsonView String tag) throws Exception {

        Collection<Company> companies = companyService.getAll();
        System.out.println("RETRIEVE-Companies");
        for (Iterator<Company> companyIterator = companies.iterator(); companyIterator.hasNext(); ) {
            Company company = companyIterator.next();
            if (!company.getTag().toLowerCase().contains(tag.toLowerCase())) {
                companyIterator.remove();
            }
        }
        return companies;
    }

    @GET
    @Path("/employees/{tag}")
    @JsonView(View.Public.class)
    @PermitAll
    public Collection<Employee> retrieveEmployee(@PathParam("tag") @JsonView String tag) throws Exception {

        Collection<Employee> employees = employeeService.getAll();
        System.out.println("RETRIEVE-Employees");
        for (Iterator<Employee> employeeIterator = employees.iterator(); employeeIterator.hasNext(); ) {
            Employee employee = employeeIterator.next();
            if (!employee.getTag().toLowerCase().contains(tag.toLowerCase())) {
                employeeIterator.remove();
            }
        }
        return employees;
    }
}
