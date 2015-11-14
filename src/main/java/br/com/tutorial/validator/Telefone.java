package br.com.tutorial.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.constraints.Pattern;

@Documented
@Target(ElementType.FIELD)
@Constraint(validatedBy = {})
@Retention(RetentionPolicy.RUNTIME)
@Pattern(regexp="^(\\+\\d)*\\s*(\\(\\d{3}\\)\\s*)*\\d{3}(-{0,1}|\\s{0,1})\\d{2}(-{0,1}|\\s{0,1})\\d{2}$", message="Telefone Inválido")
public @interface Telefone {
 

}
