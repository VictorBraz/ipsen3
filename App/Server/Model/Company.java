package Server.Model;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mitch
 */

import Server.View;
import com.fasterxml.jackson.annotation.JsonView;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author Mitch van Wijngaarden
 */
public class Company {

    @NotEmpty
    @JsonView(View.Public.class)
    private int id;

    @NotEmpty
    @JsonView(View.Public.class)
    private int companyAddressID;

    @NotEmpty
    @Length(min = 1, max = 100)
    @JsonView(View.Public.class)
    private String phoneNumber;

    @NotEmpty
    @Length(min = 1, max = 100)
    @JsonView(View.Public.class)
    private String companyName;

    @NotEmpty
    @Email
    @JsonView(View.Public.class)
    private String email;

    @JsonView(View.Public.class)
    private String tag;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCompanyAddressID() {
        return companyAddressID;
    }

    public void setCompanyAddressID(int companyAddressID) {
        this.companyAddressID = companyAddressID;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
