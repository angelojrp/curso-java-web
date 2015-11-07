package br.com.tutorial.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.tutorial.model.entity.Anuncio;
import br.com.tutorial.model.entity.Categoria;
import br.com.tutorial.model.entity.UF;

/**
 * Classe resposável pela manipulção das informações de cadastro na base de dados.
 * @author angelo
 *
 */
//NOTA Não foi utilizado nenhum padrão de projeto intencionalmente, explicarei em sala de aula com usar e as vantagens
public class CadastroDAO {
	private static final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("PU-UDF");
	private EntityManager em;
	
	
	public void salvarAnuncio(Anuncio anuncio){
		em = getEntityManager();
		em.getTransaction().begin();
		em.persist(anuncio);
		em.getTransaction().commit();
	}
	
	public List<UF> getUfs(){
		List ufs = getEntityManager().createQuery("from UF").getResultList();
		return ufs;
	}
	
	public List<Categoria> getCategorias(){
		List categorias = getEntityManager().createQuery("from Categoria").getResultList();
		return categorias;
	}
	
	public EntityManager getEntityManager() {
		return EMF.createEntityManager();
	}
	
}
