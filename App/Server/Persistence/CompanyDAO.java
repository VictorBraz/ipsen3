package Server.Persistence;

import Server.Model.Company;
import com.google.inject.Singleton;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mitch on 12/9/2016.
 */
@Singleton
public class CompanyDAO
{
    private final List<Company> companies;

    public CompanyDAO()
    {
        Company cm1 = new Company();
        cm1.setId(1);
        cm1.setCompanyName("Test bedrijf");
        cm1.setCompanyAddressID(1);
        cm1.setEmail("Test@test.com");
        cm1.setPhoneNumber("435353");
        cm1.setTag("Slechtziend");

        companies = new ArrayList<>();
        companies.add(cm1);
    }

    public List<Company> getAll()
    {
        return companies;
    }

    public Company get(int id)
    {
        try
        {
            return companies.get(id);
        }
        catch(IndexOutOfBoundsException exception)
        {
            return null;
        }
    }

//    public User getByEmailAddress(String emailAddress)
//    {
//        Optional<User> result = users.stream()
//            .filter(user -> user.getEmailAddress().equals(emailAddress))
//            .findAny();
//
//        return result.isPresent()
//            ? result.get()
//            : null;
//    }

    public void add(Company company)
    {
        companies.add(company);
    }

    public void update(int id, Company company)
    {
        companies.set(id, company);
    }

    public void delete(int id)
    {
        companies.remove(id);
    }
}