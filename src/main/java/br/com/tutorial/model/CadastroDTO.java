package br.com.tutorial.model;

import java.io.Serializable;
import java.util.Date;

public class CadastroDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Date data;

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

}
