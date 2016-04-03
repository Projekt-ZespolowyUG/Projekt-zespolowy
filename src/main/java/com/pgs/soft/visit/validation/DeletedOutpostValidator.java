package com.pgs.soft.visit.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


import com.pgs.soft.visit.dto.DeletedOutpostDTO;
import com.pgs.soft.visit.service.EmployeeService;


@Component
public class DeletedOutpostValidator implements Validator {

	@Autowired
	EmployeeService employeeService;

	public boolean supports(Class clazz) {
        return DeletedOutpostDTO.class.equals(clazz);
    }

	@Override
	public void validate(Object obj, Errors errors) {
		DeletedOutpostDTO deletedoutpost = (DeletedOutpostDTO) obj;

		if (employeeService.filterEmployees(null, null, null, null, null, null, null, null, deletedoutpost.id).size() != 0) {
			errors.reject("foreign");
		}

	}
}