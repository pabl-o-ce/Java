/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsf;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

/**
 *
 * @author dfellig
 */
@Named
@SessionScoped
public class User implements Serializable {

    @Inject
    AppData appData;

    private String name;
    private String password;
    private String retypedPassword;

    public String getName() {
        return name;
    }

    public void setName(String newValue) {
        name = newValue;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRetypedPassword() {
        return retypedPassword;
    }

    public void setRetypedPassword(String retypedPassword) {
        this.retypedPassword = retypedPassword;
    }

    public String registrationUser() {
        if (appData.valUniqueUser(name)) {
            if (password.matches(retypedPassword)) {
                appData.addUserl(name, password);
                return "login?faces-redirect=true";
            } else {
                return null;
            }
        } else {
            return null;
        }

    }

    public String loginUser() {
        if (appData.loginValidate(name, password)) {
            return "index?faces-redirect=true";
        } else {
            return null;
        }
    }

    public String logoutUser() {
        appData.logoutTerm(name);
        return "login?faces-redirect=true";
    }

    public Object[] onlineUsers() {
        return appData.getOnline();
    }

    public Object[] offlineUsers() {
        return appData.getOffline();
    }

}
