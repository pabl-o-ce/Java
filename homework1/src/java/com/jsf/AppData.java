/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
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
    final private ArrayList toUserList = new ArrayList();
    private LinkedHashMap<String, Integer> userToMessagesMap = new LinkedHashMap();
    private LinkedHashMap<Integer, Message> intToMessages = new LinkedHashMap();
    Object[] registeredUserArray;
    String[] toUserArray;
    String toUsersString = "";
    String fromUser;
    Integer[] messages;
    private boolean messagesEmpty = true;
    private String messageContent;

    private String messageTextArea;

    /**
     * Creates a new instance of AppData
     */
    private int userID = 0;
    private String[] userIDs;
    private int messageCounter = 0;

    public boolean getMessagesEmpty() {
        return messagesEmpty;
    }

    public Integer[] getMessages() {
        return messages;
    }

    public void setMessages(Integer[] messages) {
        this.messages = messages;
    }

    public LinkedHashMap getUserToMessagesMap() {
        return userToMessagesMap;
    }

    public void getUserToMessagesMap(LinkedHashMap userToMessagesMap) {
        this.userToMessagesMap = userToMessagesMap;
    }

    public String getMessageTextArea() {
        return messageTextArea;
    }

    public void setMessageTextArea(String messageTextArea) {
        this.messageTextArea = messageTextArea;
    }

    public String getToUsersString() {

        return toUsersString;
    }

    public void setToUsersString(String toUsersString) {
        this.toUsersString = toUsersString;
    }

    public AppData() {
    }

    public String[] getUserIDs() {
        return userIDs;
    }

    public void setUserIDs(String[] userIDs) {
        this.userIDs = userIDs;
    }

    public void addUser(String user) {
        registeredUserList.add(user);
    }

    private int generateUserID() {
        return ++userID;
    }

    public Object[] getRegisteredUserArray() {
        UIViewRoot viewRoot = FacesContext.getCurrentInstance().getViewRoot();
        UIComponent component = viewRoot.findComponent("form:userList");
        component.clearInitialState();
        registeredUserArray = registeredUserList.toArray();
        return registeredUserArray;
    }

    public void setRegisteredUserArray(Object[] registeredUserArray) {
        registeredUserList.toArray(registeredUserArray);
        this.registeredUserArray = registeredUserList.toArray();
    }

    public String[] getToUserArray() {
        return toUserArray;
    }

    public void setToUserArray(String[] toUserArray) {
        this.toUserArray = toUserArray;
    }

    public String sendMessage() {
        for (int i = 0; i < toUserArray.length; ++i) {
            Message message = new Message();
            message.setMessageText(messageTextArea);
            intToMessages.put(i, message);
            userToMessagesMap.put(toUserArray[i], i);
        }

        Application application = FacesContext.getCurrentInstance().getApplication();

        String fromUser = (String) application.evaluateExpressionGet(FacesContext.getCurrentInstance(),
                "#{user.name}", String.class);
        this.fromUser = fromUser;

        return "messageSent";
    }

    public String prepareMessage() {
        for (int i = 0; i < toUserArray.length; ++i) {

            toUsersString += toUserArray[i] + ";";
        }

        Application application = FacesContext.getCurrentInstance().getApplication();

        String fromUser = (String) application.evaluateExpressionGet(FacesContext.getCurrentInstance(),
                "#{user.name}", String.class);
        this.fromUser = fromUser;

        return "message";
    }

    public void setFromUser(String fromUser) {
        this.fromUser = fromUser;
    }

    public String getFromUser() {
        return fromUser;
    }

    public String checkForRegistered() {
        Application application = FacesContext.getCurrentInstance().getApplication();
        String fromUser = (String) application.evaluateExpressionGet(FacesContext.getCurrentInstance(),
                "#{user.name}", String.class);
        if (registeredUserList.contains(fromUser)) {
            messagesEmpty = checkIfMessagesEmpty();
            return "index";
        } else {
            return "signup";
        }
    }

    public boolean checkIfMessagesEmpty() {
        return intToMessages.isEmpty();
    }

    public String readMessage() {
        messageContent = intToMessages.get(messages[0]).getMessageText();
        return "messageContent";
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

}
