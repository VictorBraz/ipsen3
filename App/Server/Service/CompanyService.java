package Server.Service;

import Server.Model.Company;
import Server.Persistence.CompanyDAO;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import java.util.Collection;

/**
 * Created by Mitch on 12/9/2016.
 */
@Singleton
public class CompanyService extends BaseService<Company>
{
    private final CompanyDAO dao;

    @Inject
    public CompanyService(CompanyDAO dao)
    {
        this.dao = dao;
    }

    public Collection<Company> getAll() {
        System.out.println("Get all companies called.");
        return dao.getAll();
    }

    public Company get(int id) {
        System.out.println("Get company called.");
        Company c = dao.getCompany(id);
        System.out.println(c.getCompanyName());
        return dao.getCompany(id);
    }

    public void add(Company comp){
        dao.addCompany(comp);
    }

    public void delete(int id)
    {
        //dao.delete(id);
    }
}
