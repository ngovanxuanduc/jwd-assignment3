package fa.annotaion;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Pattern;

@Target({ ElementType.PARAMETER, ElementType.FIELD })
@Constraint(validatedBy = {PhoneValidator.class})
@Retention(RetentionPolicy.RUNTIME)
//@Pattern(regexp = "\\d{10}")
public @interface Phone {
	
	String message() default "{invalid.phone}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
