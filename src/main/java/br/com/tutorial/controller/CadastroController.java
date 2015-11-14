package br.com.tutorial.controller;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

import br.com.tutorial.model.CadastroDTO;
import br.com.tutorial.model.entity.Categoria;
import br.com.tutorial.model.entity.UF;
import br.com.tutorial.model.service.CadastroAnuncioService;


@ManagedBean(name="cadastroController")
@RequestScoped
public class CadastroController implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private CadastroDTO dto = new CadastroDTO();

	private CadastroAnuncioService service = new CadastroAnuncioService();

	public CadastroDTO getDto() {
		return dto;
	}


	public void setDto(CadastroDTO dto) {
		this.dto = dto;
	}

	public List<UF> getUfs(){
		return service.getUfs();
	}
	
	public List<Categoria> getCategorias(){
		return service.getCategorias();
	}
	
	public String salvar(){
		service.salvarAnuncio(dto);
		return "index";
	}
	
}
