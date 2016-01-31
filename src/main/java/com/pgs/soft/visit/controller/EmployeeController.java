package com.pgs.soft.visit.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pgs.soft.visit.domain.Employee;
import com.pgs.soft.visit.service.EmployeeService;
import com.pgs.soft.visit.validation.EmployeeValidator;


@Controller
@RequestMapping(value = "/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private EmployeeValidator employeeValidator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(employeeValidator);
	}
	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Employee addEmployee(@Valid Employee employee) {

		employeeService.addEmployee(employee);

		return employee;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
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
	public Employee updateEmployee(@ModelAttribute @Valid Employee employee) {

		employeeService.updateEmployee(employee);

		return employee;

	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	public void deleteEmployee(@PathVariable Long id) {

		employeeService.deleteEmployee(id);

	}

}