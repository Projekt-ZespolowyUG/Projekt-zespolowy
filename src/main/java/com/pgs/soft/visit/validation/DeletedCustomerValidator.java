package com.pgs.soft.visit.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.pgs.soft.visit.dto.DeletedCustomerDTO;
import com.pgs.soft.visit.service.VisitService;

@Component
public class DeletedCustomerValidator implements Validator {
	
	@Autowired
	VisitService visitService;
	
	public boolean supports(Class clazz) {
        return DeletedCustomerDTO.class.equals(clazz);
    }

	@Override
	public void validate(Object obj, Errors errors) {
		DeletedCustomerDTO deletedcustomer = (DeletedCustomerDTO) obj;

		if (visitService.filterVisits(null, null, null, deletedcustomer.id).size() != 0) {
			errors.reject("foreign");
		}

	}
}