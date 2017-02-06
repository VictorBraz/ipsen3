package Server.Service;

import java.util.Collection;
import javax.inject.Inject;
import javax.inject.Singleton;

import Server.BCrypt;
import Server.Model.User;
import Server.Persistence.UserDAO;

/**
 * The type User service.
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

    /**
     * Gets all.
     *
     * @return the all
     */
    public Collection<User> getAll()
    {
        return dao.getAll();
    }

    /**
     * Get user.
     *
     * @param id the id
     * @return the user
     */
    public User get(int id)
    {
        return requireResult(
                dao.getUser(id));

    }

    /**
     * Add.
     *
     * @param user the user
     */
    public void add(User user) {
        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
        dao.add(user);
    }

    /**
     * Update.
     *
     * @param authenticator the authenticator
     * @param id            the id
     * @param user          the user
     */
    public void update(User authenticator, int id, User user)
    {
        // Controleren of deze gebruiker wel bestaat
        User oldUser = get(id);

        //Admin is 1
        if (!authenticator.hasRole("1"))
        {
            // Vaststellen dat de geauthenticeerde gebruiker zichzelf aan het aanpassen is
            assertSelf(authenticator, oldUser);
        }

        dao.update(id, user);
    }

    /**
     * Delete.
     *
     * @param id the id
     */
    public void delete(int id)
    {
        dao.delete(id);
    }
}
