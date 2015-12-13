package com.pgs.soft.visit.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<Email, String> {

	 @Override
	    public void initialize(Email paramA) {
	    }
	 
	    @Override
	    public boolean isValid(String emailNo, ConstraintValidatorContext ctx) {
	        if(emailNo == null){
	            return true;
	        } 
	         if (emailNo.matches("\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}\\b")) return true;
	    
	    else return false;
	    }
}
