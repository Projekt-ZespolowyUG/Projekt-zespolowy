package com.pgs.soft.visit.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.pgs.soft.visit.domain.Employee;
import com.pgs.soft.visit.service.EmployeeService;

@Controller

public class EmployeeController {

	
	  @Autowired
	    private EmployeeService employeeService;
	  
	  
	    @RequestMapping(value="/addEmployee", method=RequestMethod.GET )
	    public ModelAndView addEmployeePage() {
	        ModelAndView modelAndView = new ModelAndView("employee");
	        modelAndView.addObject("employee", new Employee());
	        return modelAndView;
	    }
	     
	    @RequestMapping(value="/add", method=RequestMethod.POST )
	    public ModelAndView addingEmployee(@ModelAttribute Employee employee) {
	         
	        ModelAndView modelAndView = new ModelAndView("index");
	        employeeService.addEmployee(employee);
	         
	        String message = "Employee was successfully added.";
	        modelAndView.addObject("message", message);
	         
	        return modelAndView;
	    }
	  
	  
	    @RequestMapping(value="/showEmployee")
	    public ModelAndView listOfEmployees() {
	    	
	        ModelAndView modelAndView = new ModelAndView("employee");
	        List<Employee> employees = employeeService.getEmployees();
	        modelAndView.addObject("employees", employees);
	         
	        return modelAndView;
	    }
	  
	  
	  
}