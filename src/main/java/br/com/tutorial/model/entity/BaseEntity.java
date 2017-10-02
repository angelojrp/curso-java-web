package br.com.tutorial.model.entity;

import java.io.Serializable;

/**
 * Esta classe define a estrutura básica para as entidade que serão mapeadas pelo JPA.
 * @author angelo.pereira
 *
 */
public abstract class BaseEntity {
	
	/**
	 * Retorna o identificador da entidade.<br />
	 * <b>Nota:</b> Método utilizado para padronizar a chave primária da entidade. 
	 * @return
	 */
	public abstract Serializable getId();

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		return result;
	}

	/**
	 * Método marcado como final para garantir que seja usado apenas o id da
	 * entidade como atribuito para comparação.
	 */
	@Override
	public final boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;

		Class<?> clazz = HibernateProxyExtractor.extractClass(obj);

		if (getClass() != clazz)
			return false;
		BaseEntity other = (BaseEntity) obj;
		if (getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!getId().equals(other.getId()))
			return false;
		return true;
	}

	/*
	 * Implementação básica do toString(). <br />
	 * Retorna o nome da classe e o id da entidade. <br />
	 * Este método deve ser sobrescrito para fornecer uma representação mais
	 * intuitiva sobre a entidade.
	 */
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append(getClass().getName()).append("[id = ").append(getId())
				.append("]");
		return s.toString();
	}
	


}
