package Server.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * The type Database service.
 *
 * @author Victor Machado Braz, Negin Nafissi
 */
public class DatabaseService {
    /**
     * @author Victor Machado Braz
     */
    private static DatabaseService connectionInstance;


    private DatabaseService() {
        super();

        try {
            Class.forName("org.postgresql.Driver");


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }

    }


    /**
     * Gets instance.
     *
     * @return instance
     * @author Victor Machado Braz
     */
    public static DatabaseService getInstance() {
        if(connectionInstance == null) {
            synchronized (DatabaseService.class){
                if(connectionInstance == null){
                    connectionInstance = new DatabaseService();
                }
            }
        }
        return connectionInstance;
    }

    /**
     * Gets connection.
     *
     * @param username the username
     * @param password the password
     * @return connection
     * @throws SQLException the sql exception
     * @author Negin Nafissi
     */
    public Connection getConnection(String username, String password) throws SQLException {


//        String URL = "jdbc:postgresql://145.97.16.190:5432/IPSEN3G10";
        String URL = "jdbc:postgresql://localhost:5432/IPSEN3G10";



//        String URL = "jdbc:postgresql://"+ getHost() +":" + getPort() +  "/" + getDatabaseName() +"";
        Properties info = new Properties();
        Connection conn = DriverManager.getConnection(URL, username, password);
        return conn;
    }

}
