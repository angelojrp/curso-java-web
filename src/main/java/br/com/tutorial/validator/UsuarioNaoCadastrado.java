package br.com.tutorial.validator;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = UsuarioNaoCadastradoValidator.class)
@Documented
public @interface UsuarioNaoCadastrado {
	
	String message() default "Usuário já cadastrado na base de dados.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
