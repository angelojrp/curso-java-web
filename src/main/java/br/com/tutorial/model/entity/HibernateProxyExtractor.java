package br.com.tutorial.model.entity;
import org.hibernate.proxy.HibernateProxy;

public class HibernateProxyExtractor {
	
	/**
	 * Metodo para remover o proxy da entidade e retornar a real classe da entidade.
	 * @param entity
	 * @return class
	 */
	public static Class<?> extractClass(Object entity){
		if (entity instanceof HibernateProxy) {
			return ((HibernateProxy) entity).getHibernateLazyInitializer().getPersistentClass();
		}else{
			return entity.getClass();
		}
	}
	
	/**
	 * Metodo para remover o proxy da entidade e retornar o real objeto da entidade.
	 * @param entity
	 * @return object
	 */
	public static Object extractEntity(Object entity){
		if (entity instanceof HibernateProxy) {
			return ((HibernateProxy) entity).getHibernateLazyInitializer().getImplementation();
		}else{
			return entity;
		}
	}

}