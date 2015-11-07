package br.com.tutorial.controller;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

import br.com.tutorial.model.CadastroDTO;
import br.com.tutorial.model.dao.CadastroDAO;
import br.com.tutorial.model.entity.Categoria;
import br.com.tutorial.model.entity.UF;


@ManagedBean(name="cadastroController")
@RequestScoped
public class CadastroController implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CadastroDTO dto = new CadastroDTO();


	public CadastroDTO getDto() {
		return dto;
	}


	public void setDto(CadastroDTO dto) {
		this.dto = dto;
	}

	public List<UF> getUfs(){
		CadastroDAO dao = new CadastroDAO();
		return dao.getUfs();
	}
	
	public List<Categoria> getCategorias(){
		CadastroDAO dao = new CadastroDAO();
		return dao.getCategorias();
	}
	
	public String salvar(){
		CadastroDAO dao = new CadastroDAO();
		dao.salvarAnuncio(dto.getAnuncio());
		return "index";
	}
	
}
