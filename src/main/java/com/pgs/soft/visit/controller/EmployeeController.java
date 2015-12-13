package com.pgs.soft.visit.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pgs.soft.visit.domain.Employee;
import com.pgs.soft.visit.service.EmployeeService;
import com.pgs.soft.visit.validation.EmployeeValidator;
import com.pgs.soft.visit.validation.PhoneValidator;



@Controller
@RequestMapping(value="/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private EmployeeValidator employeeValidator;
	
 
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(employeeValidator);
	}
	

	@RequestMapping(value = "/crud", method = RequestMethod.GET)
	public ModelAndView addEmployeePage() {
		ModelAndView modelAndView = new ModelAndView("employee");
		List<Employee> employees = employeeService.getEmployees();
		modelAndView.addObject("employees", employees);
		modelAndView.addObject("employee", new Employee());
		return modelAndView;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView addingEmployee(@ModelAttribute @Valid Employee employee, BindingResult result) {

		if (result.hasErrors())
    	{
    		 ModelAndView modelAndView = new ModelAndView("employee");
    			List<Employee> employees = employeeService.getEmployees();
    			modelAndView.addObject("employees", employees);
	    		return  modelAndView;
    	}
		ModelAndView modelAndView = new ModelAndView("employee");
		employeeService.addEmployee(employee);
		List<Employee> employees = employeeService.getEmployees();
		modelAndView.addObject("employees", employees);
		String message = "Pracownik zosta³ dodany.";
		modelAndView.addObject("message", message);

		return modelAndView;
	}



}