package com.pgs.soft.visit.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = EmailValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Email {
	String message() default "Pole Email musi miea\u0107 format x@y.z oraz musi zawiera\u0107 nie mniej ni\u017c 5 znak\u00f3w i nie wi\u0119cej ni\u017c 40 znak\u00f3w";
    
    Class<?>[] groups() default {};
      
    Class<? extends Payload>[] payload() default {};
}
