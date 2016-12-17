/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server.Service;

import java.util.Optional;

import Server.Model.Account;
import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.Authorizer;
import io.dropwizard.auth.basic.BasicCredentials;
import javax.inject.Inject;
import javax.inject.Singleton;

import Server.Persistence.AccountDAO;

/**
 *
 * @author Peter van Vliet
 */
@Singleton
public class AuthenticationService implements Authenticator<BasicCredentials, Account>, Authorizer<Account>
{
    private final AccountDAO accountDAO;

    @Inject
    public AuthenticationService(AccountDAO accountDAO)
    {
        this.accountDAO = accountDAO;
    }

    @Override
    public Optional<Account> authenticate(BasicCredentials credentials) throws AuthenticationException
    {
        Account account = accountDAO.getByAccountname(credentials.getUsername());

        if (account != null && account.getPassword().equals(credentials.getPassword()))
        {
            return Optional.of(account);
        }

        return Optional.empty();
    }

    @Override
    public boolean authorize(Account account, String roleName)
    {
        return account.hasRole(roleName);
    }
}
