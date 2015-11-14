package br.com.tutorial.model.dao;

import br.com.tutorial.model.entity.Anuncio;

/**
 * Classe resposável pela manipulação das informações de anúncio na base de dados.
 * @author angelo
 *
 */
public class AnuncioDAO extends AbstractDAO<Anuncio, Long> {
	
	
	public void salvarAnuncio(Anuncio anuncio){
		inserirOuAtualizar(anuncio);
	}
	
	
}
