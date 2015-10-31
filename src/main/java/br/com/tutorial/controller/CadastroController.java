package br.com.tutorial.controller;

import java.util.Calendar;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import br.com.tutorial.model.CadastroDTO;

@ManagedBean(name="cadastro")
public class CadastroController {
	
	private CadastroDTO dto = new CadastroDTO();
	
	public CadastroDTO getDto() {
		return dto;
	}

	public void setDto(CadastroDTO dto) {
		this.dto = dto;
	}

}
