/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsf;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author pablocarrera
 */
@Named
public class Message {

    final private ArrayList messageTotal = new ArrayList();
    private String messageText;
    private String to;
    private String from;
    private String time;
    public Message(){
        this.setTime();
        
    }
    public Message(String f, String t, String sms){
        this.setMessageText(sms);
        this.setTo(t);
        this.setFrom(f);
        this.setTime();
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setFrom(String froms) {
        this.from = froms;
    }

    public String getFrom() {
        return from;
    }

    public void setTo(String tos) {
        this.to = tos;
    }

    public String getTo() {
        return to;
    }

    public void setTime() {
        time = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
    }

    public String getTime() {
        return time;
    }

    public void addMessageTotal(String from, Date time, String mens) {
        messageTotal.add(from);
        messageTotal.add(mens);
        messageTotal.add(time);//
    }


}
