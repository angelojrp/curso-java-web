package br.com.tutorial.validator;

import java.io.Serializable;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

//Note que para a validação que envolve diversos campos, ela deve ser declara em nivel de classe
@FieldMatch.List({
		@FieldMatch(first = "senha", second = "confirmarSenha", message = "Os campos senha e confirmar senha devem ser idênticos"),
		@FieldMatch(first = "email", second = "confirmarEmail", message = "Os campos email e confirmar email devem ser idênticos") })
public class ExemploDeUso implements Serializable {

	private static final long serialVersionUID = 1L;

	//Podemos combinar diversas anotações de validação.
	@Email 
	@NotBlank
	private String email;
	
	private String confirmarEmail;
	
	@NotBlank
	@Size(min=6, max=20)
	@Pattern(regexp= "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})")
	private String senha;
	
	private String confirmarSenha;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getConfirmarEmail() {
		return confirmarEmail;
	}

	public void setConfirmarEmail(String confirmarEmail) {
		this.confirmarEmail = confirmarEmail;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getConfirmarSenha() {
		return confirmarSenha;
	}

	public void setConfirmarSenha(String confirmarSenha) {
		this.confirmarSenha = confirmarSenha;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExemploDeUso other = (ExemploDeUso) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ExemploDeUso [email=" + email + "]";
	}


}
