package com.pgs.soft.visit.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.pgs.soft.visit.domain.Visit;

@Component
public class VisitValidator implements Validator {
	@Override
	public boolean supports(Class<?> paramClass) {
		return Visit.class.equals(paramClass);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		Visit visit = (Visit) obj;

		if (visit.getCustomer() == null) {
			errors.rejectValue("customer", "empty");
		}
		if (visit.getEmployee() == null) {
			errors.rejectValue("employee", "empty");
		}
		if (visit.getStartDate() == null) {
			errors.rejectValue("startdate", "empty");
		}
		if (visit.getEndDate() == null) {
			errors.rejectValue("enddate", "empty");
		}
		
	}
}