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

<<<<<<< HEAD
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Employee addEmployee(@ModelAttribute @Valid Employee employee) {

		employeeService.addEmployee(employee);

		return employee;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Employee getById(@PathVariable("id") Integer id) {
		Employee employee = employeeService.getEmployee(id);
		return employee;
=======
	/* @RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView addEmployee(@ModelAttribute @Valid Employee employee, BindingResult result) {

		if (result.hasErrors())
    	{
    		 ModelAndView modelAndView = new ModelAndView("employee");
    			List<Employee> employees = employeeService.getEmployees();
    			modelAndView.addObject("employees", employees);
	    		return  modelAndView;
    	}
		ModelAndView modelAndView = new ModelAndView("employee");
		employeeService.addEmplWoyee(employee);
		List<Employee> employees = employeeService.getEmployees();
		modelAndView.addObject("employees", employees);
		String message = "Pracownik zosta³ dodany.";
		modelAndView.addObject("message", message);

	return modelAndView;
	} */
	
	 @RequestMapping(value = "/list", method = RequestMethod.GET)
	    public String listEmployees(Model model) {
	        model.addAttribute("employee", new Employee());
	        model.addAttribute("getEmployees", employeeService.getEmployees());
	        return "outpost";
	    }
	 
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addEmployee (@ModelAttribute @Valid Employee employee, BindingResult result)
	{
		employeeService.addEmployee(employee);
		return "redirect:/list";
		
		/*  if(employee.getIdEmployee() == 0){
        
        employeeService.addEmployee(employee);
    }else{
        
        employeeService.updateEmployee(employee);
    }
    return "employee";*/
				
>>>>>>> 735ba27ba731fba03dde87ced6c9a650f87be8d1
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Employee updateEmployee(@ModelAttribute @Valid Employee employee) {

		employeeService.updateEmployee(employee);

		return employee;

	}

}