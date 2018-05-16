package com.ips.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import com.ips.model.Contacto;
import com.ips.repository.Contactos;

@FacesConverter(forClass = Contacto.class)
public class ContactoConverter implements Converter{

	@Inject
	private Contactos contactos;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Contacto retorno = null;		

		if(StringUtils.isNotEmpty(value)){
			Long idcontacto = new Long(value);
			retorno = contactos.porId(idcontacto);
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Contacto contacto = (Contacto) value;
			return contacto.getIdcontacto() == null ? null : contacto.getIdcontacto().toString();			
		}

		return "";
	}
	
	

}
