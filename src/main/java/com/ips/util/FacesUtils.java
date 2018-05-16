package com.ips.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


public class FacesUtils {
    
    public static void agregarErrorMensaje(String message) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, message, null)); 
    }
    
    public static void agregarInfoMensaje(String message) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, null)); 
    }
    
    public static void agregarErrorMensajeLogin(String message) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, message, null)); 
    } 

    
    public static boolean isPostback() {
		return FacesContext.getCurrentInstance().isPostback();
	}
	
	public static boolean isNotPostback() {
		return !isPostback();
	}
}
