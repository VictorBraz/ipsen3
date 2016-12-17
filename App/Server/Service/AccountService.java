package Server.Service;

import java.util.Collection;
import javax.inject.Inject;
import javax.inject.Singleton;

import Server.Model.Account;
import Server.Persistence.AccountDAO;

/**
 *
 * @author Negin Nafissi
 */
@Singleton
public class AccountService extends BaseService<Account>
{
    private final AccountDAO dao;

    @Inject
    public AccountService(AccountDAO dao)
    {
        this.dao = dao;
    }

    public Collection<Account> getAll()
    {
        return dao.getAll();
    }

    public Account getAccount(int id)
    {
        return requireResult(dao.getAccount(id));
    }

    public void addAccount(Account account)
    {
        account.setRoles(new String[] { "GUEST" });

        dao.addAccount(account);
    }

    public void update(Account authenticator, int id, Account account)
    {
        // Controleren of deze gebruiker wel bestaat
        Account oldAccount = getAccount(id);

        if (!authenticator.hasRole("ADMIN"))
        {
            // Vaststellen dat de geauthenticeerde gebruiker
            // zichzelf aan het aanpassen is
            assertSelf(authenticator, oldAccount);
        }

//        dao.update(id, account);
    }

    public void delete(int id)
    {
        // Controleren of deze gebruiker wel bestaat
//        Account account = get(id);

//        dao.delete(id);
    }
}
