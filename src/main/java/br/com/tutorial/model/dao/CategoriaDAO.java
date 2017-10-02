package br.com.tutorial.model.dao;

import java.util.List;

import br.com.tutorial.model.entity.Categoria;

public class CategoriaDAO extends AbstractDAO<Categoria, Long> {

	/**
	 * Recupera a lista com todas as categorias.
	 * @return
	 */
	public List<Categoria> buscarTodasCategoria(){
		return buscarTodos();
	}
	
	/**
	 * Recupera as informações de uma categoria a partir do identificador (PK)
	 * 
	 * @param id - Código identificador da categoria.
	 * 
	 * @return Instancia de {@link Categoria}
	 */
	public Categoria recuperarCategoriaPorId(Long id) throws IllegalArgumentException{
		if(id == null){
			throw new IllegalArgumentException("O código da categoria é obrigatório");
		}
		return buscar(id);
	}
}
