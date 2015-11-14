package br.com.tutorial.model;

import java.io.Serializable;

import br.com.tutorial.model.entity.Anuncio;
import br.com.tutorial.model.entity.Usuario;

public class CadastroDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	
	private Anuncio anuncio;
	private Usuario usuario;

	public Anuncio getAnuncio() {
		if(anuncio == null){
			this.anuncio = new Anuncio();
		}
		return anuncio;
	}

	public void setAnuncio(Anuncio anuncio) {
		this.anuncio = anuncio;
	}

	public Usuario getUsuario() {
		if(usuario == null){
			this.usuario = new Usuario();
		}
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	

}
