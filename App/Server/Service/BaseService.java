package Server.Service;

import javax.ws.rs.ForbiddenException;
import javax.ws.rs.NotFoundException;
import Server.Model.User;

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

    public void assertSelf(User user1, User user2)
    {
        if (!user1.equals(user2))
        {
            throw new ForbiddenException();
        }
    }
}
