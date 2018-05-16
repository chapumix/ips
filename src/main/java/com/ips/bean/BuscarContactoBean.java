package com.ips.bean;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.ips.model.Contacto;
import com.ips.repository.Contactos;
import com.ips.util.FacesUtils;

@Named(value = "BuscarContactoBean")
@ViewScoped
public class BuscarContactoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Contactos contactos;

	private Contacto contactoseleccionado;
	private List<Contacto> listado;
	private ResourceBundle config;	
	

	public BuscarContactoBean() {
		config = ResourceBundle.getBundle("Messages");
	}	

	// metodos
	public void eliminar(){
		contactos.eliminar(contactoseleccionado);		
		FacesUtils.agregarInfoMensaje(config.getString("registroeliminado"));
	}
	
	
	//getters and setters	

	public Contacto getContactoseleccionado() {
		return contactoseleccionado;
	}

	public void setContactoseleccionado(Contacto contactoseleccionado) {
		this.contactoseleccionado = contactoseleccionado;
	}

	public List<Contacto> getListado() {
		this.listado = contactos.listado();
 		return listado;
	}	
	
}
