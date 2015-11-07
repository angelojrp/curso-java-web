package br.com.tutorial.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.commons.lang.StringUtils;

import br.com.tutorial.model.entity.Categoria;

@FacesConverter(value="categoriaConverter")
public class CategoriaConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		if(StringUtils.isNotBlank(value) ){
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU-UDF");
			EntityManager em = emf.createEntityManager();
			return em.find(Categoria.class, Long.valueOf(value));
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
