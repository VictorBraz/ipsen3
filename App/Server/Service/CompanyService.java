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
        return dao.getAll();
    }

    public Company get(int id) {
        return dao.getCompany(id);
    }

    public void update(Company comp) {
        dao.update(comp);
    }

    public void add(Company comp){
        dao.addCompany(comp);
    }

    public void delete(int id)
    {
        dao.delete(id);
    }
}
