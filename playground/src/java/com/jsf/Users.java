/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsf;

/**
 *
 * @author pablocarrera
 */
public class Users {
    private String username;
    private String password;
    private String retypedPassword;
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String newValue) {
        username = newValue;
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
}
