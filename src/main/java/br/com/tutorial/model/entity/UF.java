package br.com.tutorial.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Entidade que armazena as informações da unidade federativa
 * @author angelo
 *
 */
/**
 * @author angelo.pereira
 *
 */
@Entity
@Table(name = "UF")
public class UF extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "sigla", length = 2, nullable = false)
	private String id;

	@Column(name = "nome", length = 45, nullable = false)
	private String nome;

	@Transient
	private String sigla;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Recupera a sigla da UF
	 * 
	 * @return String contendo a sigla da UF
	 */
	public String getSigla() {
		return getId();
	}

	/**
	 * Recupera o nome da UF
	 * 
	 * @return String contendo o nome da UF
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Atribui o nome da UF
	 * 
	 * @param nome
	 *            - String contendo o nome da UF
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sigla == null) ? 0 : sigla.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "UF [sigla=" + sigla + ", nome=" + nome + "]";
	}
}
