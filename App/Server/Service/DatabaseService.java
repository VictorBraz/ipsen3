package Server.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by Victor on 9-12-2016.
 */
public class DatabaseService {
    /**
     * @author Victor
     */
    private static DatabaseService connectionInstance;


    private DatabaseService() {
        super();

        try {
            Class.forName("org.postgresql.Driver");


        } catch (ClassNotFoundException e) {
            System.out.println("Error: Class not found");
            e.printStackTrace();
            return;
        }

    }


    /**
     * @author Victor
     * @return
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
     * @author
     * @return
     * @throws SQLException
     */
    public Connection getConnection(String username, String password) throws SQLException {

        String URL = "jdbc:postgresql://145.97.16.190:5432/IPSEN3G10";
        //String URL = "jdbc:postgresql://localhost:5432/HubSpot";


        //String URL = "jdbc:postgresql://"+ getHost() +":" + getPort() +  "/" + getDatabaseName() +"";
        Properties info = new Properties();
        Connection conn = DriverManager.getConnection(URL, username, password);
        return conn;
    }

}
