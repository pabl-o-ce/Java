/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsf;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author pablocarrera
 */
@SessionScoped
@ManagedBean
public class MessageController implements java.io.Serializable {
    int hitCounter = 0;
    private String javaText;

    /**
     * Creates a new instance of MessageController
     */
    public MessageController() {
        javaText = null;
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Managed Bean Initialized", null);
        
        FacesContext.getCurrentInstance().addMessage(null, facesMsg);
    }
    
    public void newMessage(){
        String hitMessage = null;
        hitCounter++;
        if(hitCounter > 1){
            hitMessage = hitCounter + " times";
        } else {
            hitMessage = hitCounter + " time";
        }
        
        Date currDate = new Date();
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                "You've pressed that button " + hitMessage + "!  The current date and time: " 
                + currDate, null);
        FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        
        if (getJavaText().equalsIgnoreCase("java")){
            FacesMessage javaTextMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, 
                "Good Job, that is the correct text!", null);
            FacesContext.getCurrentInstance().addMessage("componentForm:javaText", javaTextMsg);
        } else {
            FacesMessage javaTextMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                "Sorry, that is NOT the correct text!", null);
            FacesContext.getCurrentInstance().addMessage("componentForm:javaText", javaTextMsg);
        }
    }

    /**
     * @return the javaText
     */
    public String getJavaText() {
        return javaText;
    }

    /**
     * @param javaText the javaText to set
     */
    public void setJavaText(String javaText) {
        this.javaText = javaText;
    }
}

