package com.ips.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.Map;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.ips.util.FacesUtils;

@Named(value = "LoginBean")
@SessionScoped
public class LoginBean implements Serializable{

	private static final long serialVersionUID = 1L;		
	
	private String usuario;	
	
	//metodos
	
	public void preRender() {
		Map<String,String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
	    String parametro = params.get("invalid");		
		if ("true".equals(parametro)) {			
			FacesUtils.agregarErrorMensajeLogin("Usuario o contraseña no válida");
		}
	}
	
	public String login() throws ServletException, IOException{
		 ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
	     RequestDispatcher dispatcher = ((ServletRequest) context.getRequest()).getRequestDispatcher("/j_spring_security_check");
	     dispatcher.forward((ServletRequest) context.getRequest(), (ServletResponse) context.getResponse());
	     FacesContext.getCurrentInstance().responseComplete();
	     return null;
	}	
}