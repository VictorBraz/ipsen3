package Server.Service;

import javax.ws.rs.ForbiddenException;
import javax.ws.rs.NotFoundException;
import Server.Model.Account;

/**
 *
 * @author Peter van Vliet
 * @param <T>
 */
public class BaseService<T>
{
    public T requireResult(T model)
    {
        if (model == null)
        {
            throw new NotFoundException();
        }

        return model;
    }

    public void assertSelf(Account account1, Account account2)
    {
        if (!account1.equals(account2))
        {
            throw new ForbiddenException();
        }
    }
}
