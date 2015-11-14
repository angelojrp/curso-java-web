package br.com.tutorial.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.apache.commons.lang.StringUtils;

import br.com.tutorial.model.dao.CategoriaDAO;
import br.com.tutorial.model.entity.Categoria;

@FacesConverter(value="categoriaConverter")
public class CategoriaConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		if(StringUtils.isNotBlank(value) ){
			CategoriaDAO dao = new CategoriaDAO();
			return dao.recuperarCategoriaPorId(Long.valueOf(value));
		}
        
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if(value != null){
			return ((Categoria)value).getId().toString();
		}
		return null;
	}

}
