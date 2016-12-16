package Server.Persistence;

import Server.Service.DatabaseService;

import javax.inject.Singleton;
import java.sql.Connection;

/**
 * Created by Victor on 9-12-2016.
 */
public abstract class DatabaseDAO {

    @Singleton
    protected Connection conn;

    public DatabaseDAO() throws Exception{
        this.conn = DatabaseService.getInstance().getConnection("IPSEN3G10", "IPSEN3G10");
    }
}
