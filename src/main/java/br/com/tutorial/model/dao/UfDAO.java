package br.com.tutorial.model.dao;

import java.util.List;

import br.com.tutorial.model.entity.UF;

public class UfDAO extends AbstractDAO<UF, String> {

	public List<UF> getUfs(){
		return buscarTodos();
	}
}
