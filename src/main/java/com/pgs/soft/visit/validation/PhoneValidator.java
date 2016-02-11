package com.pgs.soft.visit.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneValidator implements ConstraintValidator<Phone, String> {

	@Override
	public void initialize(Phone paramA) {
	}

	@Override
	public boolean isValid(String phoneNo, ConstraintValidatorContext ctx) {
		if (phoneNo == null) {
			return true;
		}
		if (phoneNo.matches("^(?=.{2,12}$)\\d[0-9]*"))
			return true;
		// else if (phoneNo.matches("\\d{7}")) return true;
		// else if(phoneNo.matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{3}"))
		// return true;
		// else if(phoneNo.matches("\\d{3}-\\d{3}-\\d{3}\\s(x|(ext))\\d{3,5}"))
		// return true;
		// else if(phoneNo.matches("\\(\\d{3}\\)-\\d{3}-\\d{3}")) return true;
		// else if(phoneNo.matches("\\d{3}[-\\.\\s]\\d{2}[-\\.\\s]\\d{2}"))
		// return true;
		// else if(phoneNo.matches("\\d{3}-\\d{2}-\\d{2}\\s(x|(ext))\\d{3,5}"))
		// return true;
		// else if(phoneNo.matches("\\(\\d{3}\\)-\\d{2}-\\d{2}")) return true;

		else
			return false;
	}

}