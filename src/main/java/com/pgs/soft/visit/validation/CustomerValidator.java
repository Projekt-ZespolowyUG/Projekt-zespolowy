package com.pgs.soft.visit.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.pgs.soft.visit.domain.Customer;

@Component
public class CustomerValidator implements Validator {

	@Override
	public boolean supports(Class<?> paramClass) {
		return Customer.class.equals(paramClass);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		Customer customer = (Customer) obj;

		if (customer.getFirstName().length() == 0) {
			errors.rejectValue("firstName", "empty");
		} else if (customer.getFirstName().length() < 2 || customer.getFirstName().length() > 20) {
			errors.rejectValue("firstName", "firstName");
		}
		if (customer.getLastName().length() == 0) {
			errors.rejectValue("lastName", "empty");
		} else if (customer.getLastName().length() < 2 || customer.getFirstName().length() > 40) {
			errors.rejectValue("lastName", "lastName");
		}
		
	}
}
