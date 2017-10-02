package br.com.tutorial.model.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.tutorial.model.entity.BaseEntity;

/**
 * 
 * Fornece métodos para CRUD simples.
 * 
 * @author Angelo Pereira
 * @email angelojrp@gmail.com
 * 
 * 
 * @param <T>
 *            - Classe da entidade para qual a DAO esta sendo criada
 * @param <PK>
 *            - Tipagem da chave primária.
 */
public abstract class AbstractDAO<T extends BaseEntity, PK extends Serializable> {

	private static final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("PU-UDF");
	private EntityManager em;

	private final Class<T> entityType;

	public AbstractDAO() {
		em = getEntityManager();
		entityType = getEntityType();
	}

	/*
	 * Recupera o tipo da entidade
	 */
	@SuppressWarnings("unchecked")
	private Class<T> getEntityType() {
		Type superClass;

		// Get the generic super class of the super class if it's a cglib proxy
		if (getClass().getName().contains("$$EnhancerByCGLIB$$")) {
			superClass = getClass().getSuperclass().getGenericSuperclass();
		} else {
			superClass = getClass().getGenericSuperclass();
		}

		if (superClass instanceof ParameterizedType) {
			ParameterizedType parameterizedType = (ParameterizedType) superClass;
			if (parameterizedType.getActualTypeArguments().length > 0) {
				return (Class<T>) parameterizedType.getActualTypeArguments()[0];
			} else {
				throw new RuntimeException("Não foi possível identificar o tipo da entidade: " + superClass);
			}

		} else {
			throw new RuntimeException("Não foi possível identificar o tipo da entidade: " + superClass);
		}

	}

	/**
	 * Insere uma nova entidade na base de dados.
	 * 
	 * @param entity
	 */
	protected void inserir(T entity) {
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
	}

	protected T atualizar(T entity) {
		em.getTransaction().begin();
		em.merge(entity);
		em.getTransaction().commit();
		return entity;
	}

	protected T inserirOuAtualizar(T entity) {
		if (entity != null) {
			if (entity.getId() == null) {
				this.inserir(entity);
			} else {
				return atualizar(entity);
			}
		}
		return entity;
	}

	protected T buscar(PK primaryKey) {
		return (T) em.find(entityType, primaryKey);
	}

	/**
	 * Verifica se o registro existe na base a partir de sua chave.
	 * 
	 * @param primaryKey
	 * @return
	 */
	protected boolean existe(PK primaryKey) {
		return em.find(entityType, primaryKey) != null;
	}

	/**
	 * Exclui a entidade da base de dados a partir do identificador da entidade.
	 * 
	 * @param id
	 */
	protected void apagarPorId(PK id) {
		em.getTransaction().begin();
		em.remove(buscar(id));
		em.getTransaction().commit();
	}

	/**
	 * Exclui a entidade da base de dados.
	 * 
	 * @param entity
	 */
	protected void apagar(T entity) {
		em.getTransaction().begin();
		em.remove(entity);
		em.getTransaction().commit();
	}

	protected List<T> buscarTodos() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<T> cq = cb.createQuery(entityType);
		Root<T> rootEntry = cq.from(entityType);
		CriteriaQuery<T> all = cq.select(rootEntry);
		TypedQuery<T> allQuery = em.createQuery(all);
		return allQuery.getResultList();
	}


	protected EntityManager getEntityManager() {
		if (em == null || !em.isOpen()) {
			em = EMF.createEntityManager();
		}
		return em;
	}

}