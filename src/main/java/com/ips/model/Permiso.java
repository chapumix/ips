package com.ips.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the permiso database table.
 * 
 */
@Entity
@NamedQuery(name="Permiso.findAll", query="SELECT p FROM Permiso p")
public class Permiso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String idpermiso;

	private String nombre;

	//bi-directional many-to-many association to Usuario
	@ManyToMany(mappedBy="permisos")
	private List<Usuario> usuarios;

	public Permiso() {
	}

	public String getIdpermiso() {
		return this.idpermiso;
	}

	public void setIdpermiso(String idpermiso) {
		this.idpermiso = idpermiso;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}