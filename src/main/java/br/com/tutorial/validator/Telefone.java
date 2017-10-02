package br.com.tutorial.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Pattern;

@Documented
@Target(ElementType.FIELD)
@Constraint(validatedBy = {})
@Retention(RetentionPolicy.RUNTIME)
@Pattern(regexp="[0-9]{1,2}\\s[0-9]{4,5}[-][0-9]{4,5}", message="Telefone Inválido")
public @interface Telefone {

	String message() default "Telefone Inválido";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
