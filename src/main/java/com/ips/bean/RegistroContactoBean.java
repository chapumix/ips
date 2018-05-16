package com.ips.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;

import com.ips.model.Contacto;
import com.ips.service.ContactoService;
import com.ips.util.FacesUtils;

@Named(value = "RegistroContactoBean")
@ViewScoped
public class RegistroContactoBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ContactoService contactoService;	
	
	private Contacto contacto;	
	private ResourceBundle config;
	
		
	public RegistroContactoBean() {
		limpiar();
		config = ResourceBundle.getBundle("Messages");
		
	}
	
		
	//metodos

	public void inicializar(){
		if(this.contacto == null){
            limpiar();
        }		
	}	
	
	private void limpiar(){
		this.contacto = new Contacto();			
	}
	
	
	public void guardar(){
		
		this.contacto = contactoService.guardar(this.contacto);
		limpiar();		
		FacesUtils.agregarInfoMensaje(config.getString("registroguardado"));
	}	
	
	
	public boolean tituloEditar(){
		return this.contacto.getIdcontacto() != null;
	}
		
	
	// getters and setters


	public Contacto getContacto() {
		return contacto;
	}


	public void setContacto(Contacto contacto) {
		this.contacto = contacto;
	}	

}
