package Server.Persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.inject.Singleton;
import Server.Model.User;

/**
 * The type User dao.
 *
 * @author Peter van Vliet, Negin Nafissi
 */
@Singleton
public class UserDAO extends DatabaseDAO
{
    private PreparedStatement getUser;
    private PreparedStatement addUser;
    private PreparedStatement getAll;
    private PreparedStatement deleteUser;
    private List<User> users;

    /**
     * Instantiates a new User dao.
     *
     * @throws Exception the exception
     */
    public UserDAO() throws Exception {
        super();
        prepareStatements();
        getAll();
    }

    private void prepareStatements() {
        try {
            getUser = conn.prepareStatement("SELECT * FROM account WHERE id=?");
            addUser = conn.prepareStatement("INSERT INTO account (accountname, password, privilege," +
                    " userid, active) VALUES (?, ?, ?, ?, TRUE )");
            getAll = conn.prepareStatement("SELECT * FROM account");
            deleteUser = conn.prepareStatement("UPDATE account SET active=? WHERE id =?");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets all.
     *
     * @return the all
     */
    public List<User> getAll()
    {
        users = new ArrayList<>();
        try {
            ResultSet rs = getAll.executeQuery();

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt(1));
                user.setEmailAddress(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setPrivilege(String.valueOf(rs.getInt(4)));
                user.setUserId(rs.getInt(5));
                user.setActive(rs.getBoolean(6));
                users.add(user);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    /**
     * Gets user.
     *
     * @param id the id
     * @return the user
     */
    public User getUser(int id)
    {
        User user = new User();
        try {
            getUser.setInt(1, id);
            ResultSet rs = getUser.executeQuery();

            while (rs.next()) {
                user.setId(rs.getInt(1));
                user.setEmailAddress(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setPrivilege(rs.getString(4));
                user.setUserId(rs.getInt(5));
                user.setActive(rs.getBoolean(6));
                users.add(user);
            }
        } catch (Exception e) {
            return null;
        }
        return user;
    }

    /**
     * Gets by email address.
     *
     * @param accountName the account name
     * @return the by email address
     */
    public User getByEmailAddress(String accountName) {

            Optional<User> result = users.stream().filter(user -> user.getEmailAddress().equals(accountName)).findAny();

            return result.isPresent()
                    ? result.get()
                    : null;
    }

    /**
     * Add.
     *
     * @param user the user
     */
    public void add(User user)
    {
        users.add(user);
        try{
            addUser.setString(1, user.getEmailAddress());
            addUser.setString(2, user.getPassword());
            addUser.setInt(3, user.getPrivilege());
            addUser.setInt(4, user.getUserId());

            addUser.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Update.
     *
     * @param id   the id
     * @param user the user
     */
    public void update(int id, User user)
    {
        users.set(id, user);
    }

    /**
     * Delete.
     *
     * @param id the id
     */
    public void delete(int id)
    {
        try {

            if( getUser(id).getActive()) {
                deleteUser.setBoolean(1, false);
                deleteUser.setInt(2, id);
                deleteUser.executeUpdate();
            } else {
                deleteUser.setBoolean(1, true);
                deleteUser.setInt(2, id);
                deleteUser.executeUpdate();
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
