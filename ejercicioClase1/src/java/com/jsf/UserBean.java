/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsf;

import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author pablocarrera
 */
@Named("user") // or @ManagedBean(name="user") 
@SessionScoped
public class UserBean implements Serializable {

    private String name;
    private String password;
    private String aboutYourself;

    public String getName() {
        return name;
    }

    public void setName(String newValue) {
        name = newValue;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String newValue) {
        password = newValue;
    }

    public String getAboutYourself() {
        return aboutYourself;
    }

    public void setAboutYourself(String newValue) {
        aboutYourself = newValue;
    }
}
