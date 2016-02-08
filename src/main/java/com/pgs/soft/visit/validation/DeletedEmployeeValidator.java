package com.pgs.soft.visit.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.pgs.soft.visit.domain.Employee;
import com.pgs.soft.visit.dto.DeletedEmployeeDTO;
import com.pgs.soft.visit.service.EmployeeService;
import com.pgs.soft.visit.service.VisitService;

@Component
public class DeletedEmployeeValidator implements Validator {
	@Autowired
	@Qualifier("basicValidator")
	private Validator basicValidator;

	@Override
	public boolean supports(Class<?> paramClass) {
		return DeletedEmployeeDTO.class.equals(paramClass);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		basicValidator.validate(obj, errors);
		DeletedEmployeeDTO deletedemployee = (DeletedEmployeeDTO) obj;

		final VisitService visitService;  

	}
}