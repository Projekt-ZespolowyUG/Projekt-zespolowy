package com.pgs.soft.visit.validation;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.pgs.soft.visit.domain.Employee;

@Component
public class EmployeeValidator implements Validator {
	

	@Override
	public boolean supports(Class<?> paramClass) {
		return Employee.class.equals(paramClass);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		Employee employee = (Employee) obj;

		if (StringUtils.isEmpty(employee.getFirstName())) {
			errors.rejectValue("firstName", "empty");
		} else if (employee.getFirstName().length() < 2 || employee.getFirstName().length() > 20) {
			errors.rejectValue("firstName", "firstName");
		}
		if (StringUtils.isEmpty(employee.getLastName())) {
			errors.rejectValue("lastName", "empty");
		} else if (employee.getLastName().length() < 2 || employee.getFirstName().length() > 40) {
			errors.rejectValue("lastName", "lastName");
		}
		if (StringUtils.isEmpty(employee.getAdress())) {
			errors.rejectValue("adress", "empty");
		}

		else if (employee.getAdress().length() < 2 || employee.getAdress().length() > 40) {
			errors.rejectValue("adress", "adress");
		}
		if (StringUtils.isEmpty(employee.getPostcode())) {
			errors.rejectValue("postcode", "empty");
		} else if (employee.getPostcode().length() < 2 || employee.getPostcode().length() > 10) {
			errors.rejectValue("postcode", "postcode");
		}
		if (StringUtils.isEmpty(employee.getTown())) {
			errors.rejectValue("town", "empty");
		} else if (employee.getTown().length() < 2 || employee.getTown().length() > 40) {
			errors.rejectValue("town", "town");
		}
		if (StringUtils.isEmpty(employee.getCountry())) {
			errors.rejectValue("country", "empty");
		} else if (employee.getCountry().length() < 2 || employee.getCountry().length() > 40) {
			errors.rejectValue("country", "country");
		}

	}
}
