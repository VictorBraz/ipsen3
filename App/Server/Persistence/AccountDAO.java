package Server.Persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.inject.Singleton;
import Server.Model.Account;

/**
 *
 * @author Negin Nafissi
 */
@Singleton
public class AccountDAO extends DatabaseDAO {

    private final List<Account> accounts;
    private PreparedStatement getAccount;
    private PreparedStatement addAccount;
    private PreparedStatement getAll;

    public AccountDAO(List<Account> accounts) throws Exception {
        super();
        this.accounts = accounts;
        prepareStatements();
    }

    public AccountDAO() throws Exception {
        super();
        accounts = null;
    }
    private void prepareStatements() {
        try {
            getAccount = conn.prepareStatement("SELECT * FROM account WHERE id=?");
            addAccount = conn.prepareStatement("INSERT INTO account (accountname, password, privilege, userid) VALUES (?, ?, ?, ?)");
            getAll = conn.prepareStatement("SELECT * FROM account");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void addAccount(Account account) {
        try {
            addAccount.setString(1, account.getAccountname());
            addAccount.setString(2, account.getPassword());
            addAccount.setInt(3, account.getPrivilege());
            addAccount.setInt(4, account.getUserid());

            addAccount.executeUpdate();
//            addEmployee.close();
        } catch (Exception e) {
        }
    }

        public List<Account> getAll(){
            List<Account> accounts = new ArrayList<>();
            try{
                ResultSet rs = getAll.executeQuery();

                while (rs.next()){
                    Account account = new Account();
                    account.setId(rs.getInt(1));
                    account.setAccountname(rs.getString(2));
                    account.setPassword(rs.getString(3));
                    account.setPrivilege(rs.getInt(4));
                    account.setUserid(rs.getInt(5));
                    accounts.add(account);
                }
//            getAll.close();
            }catch (Exception e) {
            }

            return accounts;
        }

    public Account getAccount(int id) {
        Account account = new Account();
        try {
            getAccount.setInt(1, id);
            ResultSet rs = getAccount.executeQuery();

            while (rs.next()) {
                account.setId(rs.getInt(1));
                account.setAccountname(rs.getString(2));
                account.setPassword(rs.getString(3));
                account.setPrivilege(rs.getInt(4));
                account.setUserid(rs.getInt(5));
            }
//            getEmployee.close();
        }catch (Exception e){
        }
        return account;
    }

    public Account getByAccountname(String accountname)
    {
        Optional<Account> result = accounts.stream()
                .filter(account -> account.getAccountname().equals(accountname))
                .findAny();
        System.out.println("------------->>>>>>>"+accountname+"<<<<<<<<----------");
        return result.isPresent()
                ? result.get()
                : null;
    }
}

//        Account account1 = new Account();
//        account1.setFullName("First user");
//        account1.setPostcode("1234AB");
//        account1.setStreetnumber("12");
//        account1.setEmailAddress("first@user.com");
//        account1.setPassword("first");
//        account1.setRoles(new String[] { "GUEST", "MEDEWERKER", "ADMIN" });
//
//        Account account2 = new Account();
//        account2.setFullName("Second user");
//        account2.setPostcode("9876ZY");
//        account2.setStreetnumber("98");
//        account2.setEmailAddress("second@user.com");
//        account2.setPassword("second");
//        account2.setRoles(new String[] { "GUEST" });
//
//        Account account3 = new Account();
//        account3.setFullName("Second user");
//        account3.setPostcode("9876ZY");
//        account3.setStreetnumber("98");
//        account3.setEmailAddress("test@test.nl");
//        account3.setPassword("test");
//        account3.setRoles(new String[] { "GUEST", "MEDEWERKER", "ADMIN" });
//
//        accounts = new ArrayList();
//        accounts.add(account1);
//        accounts.add(account2);
//        accounts.add(account3);
//    public List<Account> getAll()
//    {
//        return accounts;
//    }

//    public Account get(int id)
//    {
//        try
//        {
//            return accounts.get(id);
//        }
//        catch(IndexOutOfBoundsException exception)
//        {
//            return null;
//        }
//    }
//
//    public Account getByEmailAddress(String emailAddress)
//    {
//        Optional<Account> result = accounts.stream()
//                .filter(user -> user.getEmailAddress().equals(emailAddress))
//                .findAny();
//
//        return result.isPresent()
//                ? result.get()
//                : null;
//    }
//
//    public void add(Account account)
//    {
//        accounts.add(account);
//    }
//
//    public void update(int id, Account account)
//    {
//        accounts.set(id, account);
//    }
//
//    public void delete(int id)
//    {
//        accounts.remove(id);
//    }

