package br.com.tutorial.controller;

import java.io.IOException;
import java.math.BigDecimal;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.jboss.logging.Logger;

import br.com.uol.pagseguro.domain.checkout.Checkout;
import br.com.uol.pagseguro.enums.Currency;
import br.com.uol.pagseguro.enums.DocumentType;
import br.com.uol.pagseguro.exception.PagSeguroServiceException;
import br.com.uol.pagseguro.properties.PagSeguroConfig;

@ManagedBean(name="pagamentoController")
public class PagamentoController {
	
	public void pagar(String idPlano) throws IOException{
		String url = checkOut();
		FacesContext.getCurrentInstance()
			.getExternalContext().redirect(url);
	}
	
	private String checkOut(){
		String url = "";
		
		Checkout checkout = new Checkout();  
		  
		checkout.addItem(  
		  "DIAMANTE", // Identificação em seu sistema  
		  "Plano Anuncio Diamante", // Descrição  
		  Integer.valueOf(1), // Quantidade  
		  new BigDecimal("99.00"), // Valor unitário  
		  new Long(0), // Peso unitário, em gramas  
		  new BigDecimal("0.00") // Valor unitário do frete  
		); 
		
		checkout.setSender(  
				  "João Comprador", // Nome completo  
				  "comprador@uol.com.br", // email  
				  "11", // DDD  
				  "56273440", // Telefone  
				  DocumentType.CPF, // Tipo de documento  
				  "000.000.001-91" // Número do documento  
				);
		checkout.setCurrency(Currency.BRL);
		
	    // Referenciando a transação do PagSeguro em seu sistema  
	    checkout.setReference("REF1234-USER214-ORDER754851B");  
	      
	    // URL para onde o comprador será redirecionado (GET) após o fluxo de pagamento  
	    checkout.setRedirectURL("http://localhost:8080/");  
	      
	    // URL para onde serão enviadas notificações (POST) indicando alterações no status da transação  
	    checkout.setNotificationURL("http://localhost:8080/notifications");  
		
	    try {  
	    	  
	    	  boolean onlyCheckoutCode = false;  
	    	  url = checkout.register(PagSeguroConfig.getAccountCredentials(), onlyCheckoutCode);  
	    	  
	    	  getLooger().info(url);
	    	  
	    	} catch (PagSeguroServiceException e) {  
	    	  
	    	    getLooger().error(e.getMessage(), e);  
	    	} 
		
		return url;
	}
	
	private Logger getLooger(){
		return Logger.getLogger(PagamentoController.class);
	}

}
