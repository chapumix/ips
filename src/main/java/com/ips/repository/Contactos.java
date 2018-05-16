package com.ips.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

import com.ips.model.Contacto;
import com.ips.util.NegocioException;
import com.ips.util.Transactional;

public class Contactos implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public Contacto guardar(Contacto contacto) {
		return manager.merge(contacto);
	}
	
	@Transactional
	public void eliminar(Contacto contacto){
		
		try {
			contacto = porId(contacto.getIdcontacto());
			manager.remove(contacto);
			manager.flush();			
		} catch (PersistenceException e) {
			throw new NegocioException("Contacto no puede ser eliminado");
		}		
	}

	public Contacto porId(Long idcontacto) {
		return manager.find(Contacto.class, idcontacto);
	}
	
	public Contacto porCodigo(String identificacion) {
		try {
			return manager.createQuery("from Contacto where identificacion = :identificacion", Contacto.class).setParameter("identificacion", identificacion)
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public List<Contacto> listado() {
		try {
			return manager.createQuery("from Contacto", Contacto.class).getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}

}
