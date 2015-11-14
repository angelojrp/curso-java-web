package br.com.tutorial.model.service;

import java.util.List;

import br.com.tutorial.model.CadastroDTO;
import br.com.tutorial.model.dao.AnuncioDAO;
import br.com.tutorial.model.dao.CategoriaDAO;
import br.com.tutorial.model.dao.UfDAO;
import br.com.tutorial.model.dao.UsuarioDAO;
import br.com.tutorial.model.entity.Anuncio;
import br.com.tutorial.model.entity.Categoria;
import br.com.tutorial.model.entity.UF;

public class CadastroAnuncioService {

	/**
	 * Recupera a lista de {@link UF}
	 * @return
	 */
	public List<UF> getUfs(){
		UfDAO dao = new UfDAO();
		return dao.getUfs();
	}
	
	/**
	 * Recupera a lista de categorias.
	 * @return
	 */
	public List<Categoria> getCategorias(){
		CategoriaDAO dao = new CategoriaDAO();
		return dao.buscarTodasCategoria();
		
	}
	/**
	 * Salva o {@link Anuncio} na base de dados
	 * @param cadastro
	 */
	public void salvarAnuncio(CadastroDTO cadastro){
		//Salva o usuario
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.salvarUsuario(cadastro.getUsuario());
		
		//salva o anuncio
		AnuncioDAO dao = new AnuncioDAO();
		dao.salvarAnuncio(cadastro.getAnuncio());
	}
}
