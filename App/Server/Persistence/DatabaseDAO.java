package Server.Persistence;

import Server.Service.DatabaseService;

import javax.inject.Singleton;
import java.sql.Connection;

/**
 * @author Victor
 */
public abstract class DatabaseDAO {

    @Singleton
    protected Connection conn;

    public DatabaseDAO() throws Exception{
        this.conn = DatabaseService.getInstance().getConnection("postgres", "1");
    }
}
