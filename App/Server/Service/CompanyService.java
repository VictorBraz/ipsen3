package Server.Service;

import Server.Model.Company;
import Server.Persistence.CompanyDAO;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import java.util.Collection;

/**
 * Created by Mitch on 12/9/2016.
 * @author Bernd
 */
@Singleton
public class CompanyService extends BaseService<Company> {

    private final CompanyDAO dao;

    @Inject
    private CompanyService(CompanyDAO dao) {
        this.dao = dao;
    }

    public Collection<Company> getAll() {
        return dao.getAll();
    }

    public Company get(int id) {
        return dao.getCompany(id);
    }

    public void add(Company company) {
        dao.addCompany(company);
    }

    public void update(Company company) {
        dao.update(company);
    }

}
