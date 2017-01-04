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
 *
 * @author Peter van Vliet, Negin Nafissi
 */
@Singleton
public class UserDAO extends DatabaseDAO
{
    private PreparedStatement getUser;
    private PreparedStatement addUser;
    private PreparedStatement getAll;
    private List<User> users;

    public UserDAO() throws Exception {
        super();
        prepareStatements();
        getAll();
    }

    private void prepareStatements() {
        try {
            getUser = conn.prepareStatement("SELECT * FROM account WHERE id=?");
            addUser = conn.prepareStatement("INSERT INTO account (accountname, password, privilege, userid) VALUES (?, ?, ?, ?, ?)");
            getAll = conn.prepareStatement("SELECT * FROM account");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAll()
    {
        users = new ArrayList<>();
        try {
            ResultSet rs = getAll.executeQuery();

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt(1));
                System.out.println("//////////////////" + rs.getInt(1));
                user.setAccountName(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setPrivilege(String.valueOf(rs.getInt(4)));
                user.setUserId(rs.getInt(5));
                users.add(user);
            }
//            getAll.close();

        } catch (Exception e) {
        }
        return users;
    }

    public User getUser(int id)
    {
        User user = new User();
        try {
            getUser.setInt(1, id);
            ResultSet rs = getUser.executeQuery();

            while (rs.next()) {
                user.setId(rs.getInt(1));
                user.setAccountName(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setPrivilege(rs.getString(4));
                user.setUserId(rs.getInt(5));
                users.add(user);
            }
//            getEmployee.close();
        } catch (Exception e) {
            return null;
        }
        return users.get(id);
    }

    public User getByEmailAddress(String accountName) {

            Optional<User> result = users.stream().filter(user -> user.getAccountName().equals(accountName)).findAny();

            return result.isPresent()
                    ? result.get()
                    : null;
    }

    public void add(User user)
    {
        users.add(user);
    }

    public void update(int id, User user)
    {
        users.set(id, user);
    }

    public void delete(int id)
    {
        users.remove(id);
    }
}
