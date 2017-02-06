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
 * http://hibernate.org/validator/
 *
 * @author Peter van Vliet, Negin Nafissi, Victor Machado Braz
 */
public class User implements Principal {
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

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets email address.
     *
     * @return the email address
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Sets email address.
     *
     * @param emailAddress the email address
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets privilege.
     *
     * @return the privilege
     */
    public int getPrivilege() {
        if (this.privilege.equals("1")) {
            return 1;
        } else {
            return 3;
        }
    }

    /**
     * Set active.
     *
     * @param active the active
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * Get active boolean.
     *
     * @return the boolean
     */
    public boolean getActive() {
        return this.active;
    }

    /**
     * Sets privilege.
     *
     * @param privilege the privilege
     */
    public void setPrivilege(String privilege) {
        this.privilege = privilege;
    }

    /**
     * Gets user id.
     *
     * @return the user id
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Sets user id.
     *
     * @param userId the user id
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    @JsonIgnore
    public String getName() {
        return null;
    }


    /**
     * Has role boolean.
     *
     * @param roleName the role name
     * @return the boolean
     */
    public boolean hasRole(String roleName) {
        if (roleName.equals(privilege)) {
            return true;
        }
        return false;
    }

    /**
     * Equals boolean.
     *
     * @param user the user
     * @return the boolean
     */
    public boolean equals(User user) {
        return emailAddress.equals(user.getEmailAddress());
    }
}
