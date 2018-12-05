package mz.co.basse.utils;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import mz.co.basse.cattlecore.models.Coral;
import mz.co.basse.cattlecore.models.dao.CoralDao;
import mz.co.basse.cattlecore.models.dao.jpa.CoralJpaDao;

@FacesConverter(value="mz.co.basse.utils.CoralConverter")
public class CoralConverter implements Converter {

	CoralDao coralDao = new CoralJpaDao();
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null || value.isEmpty()) 
	        return null;
	    
	    return coralDao.find(value);
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value == null)
			return "";
		if (value instanceof Coral)
			return String.valueOf(((Coral) value).getCode());
		else
			throw new ConverterException(new FacesMessage(value + " is not a valid coral"));

	}

}
