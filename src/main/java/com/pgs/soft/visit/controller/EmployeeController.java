package com.pgs.soft.visit.controller;

import java.util.List;

import javax.validation.Valid;
import org.springframework.validation.Errors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.AbstractBindingResult;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pgs.soft.visit.domain.Employee;
import com.pgs.soft.visit.dto.DeletedEmployeeDTO;
import com.pgs.soft.visit.service.EmployeeService;
import com.pgs.soft.visit.validation.DeletedEmployeeValidator;
import com.pgs.soft.visit.validation.EmployeeValidator;
import com.pgs.soft.visit.validation.ForeignKeyException;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private EmployeeValidator employeeValidator;

	@Autowired
	private DeletedEmployeeValidator deletedemployeevalidator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(employeeValidator);
	}

	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Employee addEmployee(@RequestBody @Valid Employee employee) {

	//	employeeService.addEmployee(employee);
	
		if (employee.getId() == null) {


			employeeService.addEmployee(employee);
		} else {

			employeeService.updateEmployee(employee);
		}
		
		return employee;
	}

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public Employee getById(@PathVariable("id") Long id) {
		Employee employee = employeeService.getEmployee(id);
		return employee;
	}

	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<Employee> listEmployees() {

		return employeeService.getEmployees();
	}

	@RequestMapping(value = "/filter", method = RequestMethod.GET)
	public List<Employee> filterEmployees(@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("telephoneNumber") String telephoneNumber,
			@RequestParam("email") String email) {

		return employeeService.filterEmployees(firstName, lastName, telephoneNumber, email);

	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public Employee updateEmployee(@RequestBody @Valid Employee employee) {

		employeeService.updateEmployee(employee);

		return employee;

	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	@ResponseBody
	public void deleteEmployee(@RequestBody @PathVariable Long id)
			throws ForeignKeyException {

		DeletedEmployeeDTO deletedemployee = new DeletedEmployeeDTO(id);

		BindException errors = new BindException(deletedemployee, null);
		deletedemployeevalidator.validate(deletedemployee, errors);
	

		if (errors.hasErrors()) {
			throw new ForeignKeyException();
		} else {
			employeeService.deleteEmployee(deletedemployee.transferId());
		}

	}

}