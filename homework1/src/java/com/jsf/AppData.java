/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.Application;
import javax.faces.component.UIComponent;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Named;

/**
 *
 * @author pablocarrera
 */
@Named(value = "appData")
@ApplicationScoped
public class AppData {

    final private ArrayList registeredUserList = new ArrayList();
    final private ArrayList offline = new ArrayList();
    final private ArrayList online = new ArrayList();
    private final LinkedHashMap<String, Message> userMessagesMap = new LinkedHashMap();
    private LinkedHashMap<String, String> users = new LinkedHashMap();
    private LinkedHashMap<String, Boolean> usersStatus = new LinkedHashMap();

    public Object getUsers() {

        return registeredUserList.toArray();
    }

    public AppData() {
    }

    public void addUser(String user) {
        registeredUserList.add(user);
    }

    public void addOnlineUser(String user) {
        online.add(user);
        offline.remove(user);
    }

    public void addOfflineUser(String user) {
        offline.add(user);
        online.remove(user);
    }

    public boolean valUniqueUser(String user) {
        if (users.containsKey(user)) {
            return false;
        } else {
            return true;
        }
    }

    public void addUserl(String user, String password) {
        this.addUser(user);
        this.addOfflineUser(user);
        users.put(user, password);
        usersStatus.put(user, false);
    }

    public Object[] getrUserArray() {
        return registeredUserList.toArray();
    }

    public Object[] getrUserList() {

        return registeredUserList.toArray();
    }

    public Object[] getOnline() {
        return online.toArray();
    }

    public Object[] getOffline() {
        return offline.toArray();
    }

    public boolean loginValidate(String user, String pass) {
        boolean choice = false;
        if (users.containsKey(user)) {
            String val = users.get(user);
            if (val.equals(pass)) {
                boolean active = usersStatus.get(user);
                if (active == false) {
                    choice = true;
                    this.loginStatus(user, true);
                    this.addOnlineUser(user);
                }
            }
        }
        return choice;
    }

    public void loginStatus(String user, Boolean status) {
        usersStatus.replace(user, false, status);
    }

    public void logoutTerm(String user) {
        this.addOfflineUser(user);
        this.logoutStatus(user, false);
    }

    public void logoutStatus(String user, Boolean status) {
        usersStatus.replace(user, true, status);
    }

    public void setUserMessagesMap(String to, Message mens) {
        userMessagesMap.put(to, mens);
    }

    public Object[] getMessagesByname(String to) {
        ArrayList usersms = new ArrayList<Message>();
        for (String key : userMessagesMap.keySet()) {
            if(to.equals(userMessagesMap.get(key).getTo())){
                usersms.add(userMessagesMap.get(key));
            }
        }
        
        return usersms.toArray();
    }

}
