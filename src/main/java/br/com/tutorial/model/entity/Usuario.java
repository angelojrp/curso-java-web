package br.com.tutorial.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import br.com.tutorial.validator.Telefone;
import br.com.tutorial.validator.UsuarioNaoCadastrado;

@Entity
@Table(name = "usuario")
public class Usuario extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 4802292712271806911L;

	@Id
	@Column(name = "email")
	@Email
	@NotBlank
	@UsuarioNaoCadastrado //Explicar o motivo que esta anotacao não pode ser usada aqui.
	private String id;

	@Transient
	// Inidica que este campo não será salva na base de dados.
	private String repetirEmail;

	@NotBlank
	@Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})", 
	message = "A senha deve conter entre 6 e 20 caracteres, sendo letras minusculas e maiusculas, números e caracteres especiais @#$%")
	@Column(name = "senha")
	private String senha;

	@Transient
	private String repetirSenha;

	@NotBlank
	@Column(name = "nome")
	private String nome;

	@Telefone
	@Column(name = "telefone")
	private String telefone;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRepetirEmail() {
		return repetirEmail;
	}

	public void setRepetirEmail(String repetirEmail) {
		this.repetirEmail = repetirEmail;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getRepetirSenha() {
		return repetirSenha;
	}

	public void setRepetirSenha(String repetirSenha) {
		this.repetirSenha = repetirSenha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
