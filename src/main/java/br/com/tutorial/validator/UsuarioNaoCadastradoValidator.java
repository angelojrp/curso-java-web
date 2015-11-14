package br.com.tutorial.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.tutorial.model.dao.UsuarioDAO;


/**
 * Valida se o usuário não existe na base de dados.
 * 
 * @author angelo
 *
 */
public class UsuarioNaoCadastradoValidator implements ConstraintValidator<UsuarioNaoCadastrado, String>{

	@Override
	public void initialize(UsuarioNaoCadastrado constraintAnnotation) {
		
		
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		UsuarioDAO dao = new UsuarioDAO();
		return !dao.usuarioExiste(value);
	}

}
