package com.pgs.soft.visit.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pgs.soft.visit.domain.Employee;

import com.pgs.soft.visit.domain.Employee;
import com.pgs.soft.visit.service.EmployeeService;
import com.pgs.soft.visit.validation.EmployeeValidator;
import com.pgs.soft.visit.validation.PhoneValidator;

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

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Employee addEmployee(@ModelAttribute @Valid Employee employee) {

		employeeService.addEmployee(employee);

		return employee;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Employee getById(@PathVariable("id") Long id) {
		Employee employee = employeeService.getEmployee(id);
		return employee;
	}
	
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<Employee> listEmployees() {

		return employeeService.getEmployees();
	}


	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Employee updateEmployee(@ModelAttribute @Valid Employee employee) {

		employeeService.updateEmployee(employee);

		return employee;

	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
    public void deleteTeam(@PathVariable Long id) {
        
        employeeService.deleteEmployee(id);
        
    }

}