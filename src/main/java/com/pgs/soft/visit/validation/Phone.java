package com.pgs.soft.visit.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
 
import javax.validation.Constraint;
import javax.validation.Payload;



@Documented
@Constraint(validatedBy = PhoneValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Phone {
	//String message() default "{Phone}";
	String message() default "Pole Telefon musi zawiera\u0107 tylko cyfry, i  nie wi\u0119cej ni\u017c 12 znak\u00f3w";
    
    Class<?>[] groups() default {};
      
    Class<? extends Payload>[] payload() default {};
}
