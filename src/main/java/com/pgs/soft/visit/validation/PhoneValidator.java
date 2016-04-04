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
		if (phoneNo.matches("^(?=.{2,12}$)\\d[0-9]*")) {
			return true;
		}
		else {
			return false;
		}
	}

}