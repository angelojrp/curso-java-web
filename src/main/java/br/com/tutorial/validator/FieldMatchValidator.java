package br.com.tutorial.validator;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;

public class FieldMatchValidator implements
		ConstraintValidator<FieldMatch, Object> {
	private String firstFieldName;
	private String secondFieldName;
	private boolean caseSensitive;

	@Override
	public void initialize(final FieldMatch constraintAnnotation) {
		firstFieldName = constraintAnnotation.first();
		secondFieldName = constraintAnnotation.second();
		caseSensitive = constraintAnnotation.caseSensitive();
	}

	@Override
	public boolean isValid(final Object value,
			final ConstraintValidatorContext context) {
		try {
			final Object firstObj = BeanUtils
					.getProperty(value, firstFieldName);
			final Object secondObj = BeanUtils.getProperty(value,
					secondFieldName);

			context.buildConstraintViolationWithTemplate(
					context.getDefaultConstraintMessageTemplate())
					.addNode(secondFieldName).addConstraintViolation()
					.disableDefaultConstraintViolation();

			if (!caseSensitive && firstObj instanceof CharSequence) {
				return StringUtils.equalsIgnoreCase((CharSequence)firstObj,
						(CharSequence)secondObj);
			}
			return firstObj == null && secondObj == null || firstObj != null
					&& firstObj.equals(secondObj);
		} catch (final Exception ignore) {
			// ignore
		}
		return true;
	}

}