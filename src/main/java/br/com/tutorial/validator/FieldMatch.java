package br.com.tutorial.validator;
import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * Anotação que valida se dois campos possuem valores idênticos.
 *
 *
 *
 * Exemplo para comparar um par de campos:
 * 
 * @FieldMatch(first = "senha", second = "confirmarSenha", message = "Os campos senha e confirmar senha devem ser idênticos")
 *  
 * Exemplo para comparação de varios pares de campos:
 * @FieldMatch.List({
 *   @FieldMatch(first = "senha", second = "confirmarSenha", message = "Os campos senha e confirmar senha devem ser idênticos"),
 *   @FieldMatch(first = "email", second = "confirmarEmail", message = "Os campos email e confirmar email devem ser idênticos")})
 */
@Target({TYPE, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = FieldMatchValidator.class)
@Documented
public @interface FieldMatch
{
    String message() default "{constraints.fieldmatch}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    /**
     * @return The first field
     */
    String first();
    /**
     * @return The second field
     */
    String second();
    
    boolean caseSensitive() default true;
    /**
     * Defines several <code>@FieldMatch</code> annotations on the same element
     *
     * @see FieldMatch
     */
    @Target({TYPE, ANNOTATION_TYPE})
    @Retention(RUNTIME)
    @Documented
            @interface List
    {
        FieldMatch[] value();
    }
}