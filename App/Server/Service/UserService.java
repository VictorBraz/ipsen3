package Server.Service;

import java.util.Collection;
import javax.inject.Inject;
import javax.inject.Singleton;

import Server.BCrypt;
import Server.Model.User;
import Server.Persistence.UserDAO;

/**
 *
 * @author Peter van Vliet, Negin Nafissi
 */
@Singleton
public class UserService extends BaseService<User>
{
    private final UserDAO dao;

    @Inject
    private UserService(UserDAO dao)
    {
        this.dao = dao;
    }

    public Collection<User> getAll()
    {
        return dao.getAll();
    }

    public User get(int id)
    {
        return requireResult(
                dao.getUser(id));

    }

    public void add(User user) {
        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
        dao.add(user);
    }

    public void update(User authenticator, int id, User user)
    {
        // Controleren of deze gebruiker wel bestaat
        User oldUser = get(id);

        //Admin is 1
        if (!authenticator.hasRole("1"))
        {
            // Vaststellen dat de geauthenticeerde gebruiker
            // zichzelf aan het aanpassen is
            assertSelf(authenticator, oldUser);
        }

        dao.update(id, user);
    }

    public void delete(int id)
    {
        dao.delete(id);
    }
}
