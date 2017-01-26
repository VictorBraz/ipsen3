package Server.Model;

import Server.View;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import java.security.Principal;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Meer informatie over validatie:
 *  http://hibernate.org/validator/
 *
 * @author Peter van Vliet, Negin Nafissi
 */
public class User implements Principal
{
    @NotEmpty
    @JsonView(View.Public.class)
    private int id;

    @NotEmpty
    @Email
    @JsonView(View.Public.class)
    private String emailAddress;

    @NotEmpty
    @Length(min = 8)
    @JsonView(View.Protected.class)
    private String password;

    @JsonView(View.Public.class)
    private String privilege;

    @JsonView(View.Public.class)
    private int userId;

    @JsonView(View.Public.class)
    private boolean active;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getEmailAddress()
    {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress)
    {
        this.emailAddress = emailAddress;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public int getPrivilege()
    {
        if(this.privilege.equals("1")){
            return 1;
        }else {
            return 3;
        }
    }

    public void setActive(boolean active){
        this.active = active;
    }

    public boolean getActive(){
        return this.active;
    }

    public void setPrivilege(String privilege)
    {
        this.privilege = privilege;
    }

    public int getUserId()
    {
        return userId;
    }

    public void setUserId(int userId)
    {
        this.userId = userId;
    }

    @Override
    @JsonIgnore
    public String getName()
    {
        return null;
    }


    public boolean hasRole(String roleName){
        if(roleName.equals(privilege)) {
            return true;
        }
        return false;
    }

    public boolean equals(User user)
    {
        return emailAddress.equals(user.getEmailAddress());
    }
}
