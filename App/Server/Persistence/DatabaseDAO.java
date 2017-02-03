package Server.Persistence;

import Server.Service.DatabaseService;

import javax.inject.Singleton;
import java.sql.Connection;

/**
 * The type Database dao.
 *
 * @author Victor Machado Braz
 */
public abstract class DatabaseDAO {

    /**
     * The Conn.
     */
    @Singleton
    protected Connection conn;

    /**
     * Instantiates a new Database dao.
     *
     * @throws Exception the exception
     */
    public DatabaseDAO() throws Exception{
        this.conn = DatabaseService.getInstance().getConnection("postgres", "1");
    }
}
