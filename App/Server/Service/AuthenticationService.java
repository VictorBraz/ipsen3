/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server.Service;

import java.util.Optional;

import Server.BCrypt;
import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.Authorizer;
import io.dropwizard.auth.basic.BasicCredentials;
import javax.inject.Inject;
import javax.inject.Singleton;
import Server.Model.User;
import Server.Persistence.UserDAO;

/**
 * The type Authentication service.
 *
 * @author Peter van Vliet, Bernd Oostrum, Negin Nafissi
 */
@Singleton
public class AuthenticationService implements Authenticator<BasicCredentials, User>, Authorizer<User>
{
    private final UserDAO userDAO;

    /**
     * Instantiates a new Authentication service.
     *
     * @param userDAO the user dao
     */
    @Inject
    public AuthenticationService(UserDAO userDAO)
    {
        this.userDAO = userDAO;
    }

    @Override
    public Optional<User> authenticate(BasicCredentials credentials) throws AuthenticationException
    {
        User user = userDAO.getByEmailAddress(credentials.getUsername());



        if (user != null && BCrypt.checkpw(credentials.getPassword(), user.getPassword())) {
            return Optional.of(user);
        }

        return Optional.empty();
    }

    @Override
    public boolean authorize(User user, String roleName)
    {
        return user.hasRole(roleName);
    }
}
