package br.com.tutorial.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entidade que armazena as informações da unidade federativa
 * @author angelo
 *
 */
@Entity
@Table(name="UF")
public class UF implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="sigla", length=2, nullable=false)
	private String sigla;
	
	@Column(name="nome", length=45, nullable=false)
	private String nome;

	/**
	 * Recupera a sigla da UF
	 * @return String contendo a sigla da UF
	 */
	public String getSigla() {
		return sigla;
	}

	/**
	 * Atribui a sigla da UF
	 * @param sigla -  String contendo a sigla da UF
	 */
	public void setSigla(String sigla) {
		this.sigla = sigla;
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
	 * @param nome - String contendo o nome da UF
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

	/**
	 * Define como igual as UFs que possuem a mesma sigla
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof UF)) {
			return false;
		}
		UF other = (UF) obj;
		if (sigla == null) {
			if (other.sigla != null) {
				return false;
			}
		} else if (!sigla.equals(other.sigla)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "UF [sigla=" + sigla + ", nome=" + nome + "]";
	}
}
