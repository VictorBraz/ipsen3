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
public class CompanyService extends BaseService<Company> {

    private final CompanyDAO dao;

    /**
     * Instantiates a new Company service.
     *
     * @param dao the dao
     */
    @Inject
    public CompanyService(CompanyDAO dao) {
        this.dao = dao;
    }

    /**
     * Gets all.
     *
     * @return the all
     */
    public Collection<Company> getAll() {
        return dao.getAll();
    }

    /**
     * Get company.
     *
     * @param id the id
     * @return the company
     */
    public Company get(int id) {
        return dao.getCompany(id);
    }

    /**
     * Update.
     *
     * @param comp the comp
     */
    public void update(Company comp) {
        dao.update(comp);
    }

    /**
     * Add.
     *
     * @param comp the comp
     */
    public void add(Company comp) {
        dao.addCompany(comp);
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
