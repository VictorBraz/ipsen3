package Server.Model;

import Server.View;
import com.fasterxml.jackson.annotation.JsonView;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import java.security.Principal;

/**
 * Meer informatie over validatie:
 *  http://hibernate.org/validator/
 *
 * @author Peter van Vliet
 */
public class Account implements Principal {

    @NotEmpty
    @JsonView(View.Public.class)
    private int id;

    @NotEmpty
    @Email
    @JsonView(View.Public.class)
    private String accountname;

    @NotEmpty
    @Length(min = 8)
    @JsonView(View.Protected.class)
    private String password;

    @JsonView(View.Private.class)
    private int privilege;

    @NotEmpty
    @JsonView(View.Public.class)
    private int userid;

    @JsonView(View.Private.class)
    private String[] roles;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccountname() {
        return accountname;
    }

    public void setAccountname(String accountname) {
        this.accountname = accountname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }


    public String[] getRoles() { return roles; }

    public void setRoles(String[] roles) { this.roles = roles; }

    public int getPrivilege()
    {
        return privilege;
    }

    public void setPrivilege(int privilege)
    {
        this.privilege = privilege;
    }

    public boolean hasRole(String roleName)
    {
        if (roles != null)
        {
            for(String role : roles)
            {
                if(roleName.equals(role))
                {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean equals(Account account)
    {
        return accountname.equals(account.getAccountname());
    }

    @Override
    public String getName() {
        return null;
    }
}


