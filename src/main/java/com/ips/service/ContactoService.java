package com.ips.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.ips.model.Contacto;
import com.ips.repository.Contactos;
import com.ips.util.Transactional;

public class ContactoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Contactos contactos;

	@Transactional
	public Contacto guardar(Contacto contacto) {
		 
        return contactos.guardar(contacto);
	}

}
