package com.pgs.soft.visit.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pgs.soft.visit.domain.Employee;
import com.pgs.soft.visit.service.EmployeeService;

@Controller
public class EmployeeController {

	
	  @Autowired
	    private EmployeeService employeeService;
	  
	  
	    @RequestMapping(value="/employee/add")
	    public ModelAndView addEmployeePage() {
	        ModelAndView modelAndView = new ModelAndView("addEmployee");
	        modelAndView.addObject("employee", new Employee());
	        return modelAndView;
	    }
	     
	    @RequestMapping(value="/team/add/process")
	    public ModelAndView addingEmployee(@ModelAttribute Employee employee) {
	         
	        ModelAndView modelAndView = new ModelAndView("home");
	        employeeService.addEmployee(employee);
	         
	        String message = "Employee was successfully added.";
	        modelAndView.addObject("message", message);
	         
	        return modelAndView;
	    }
	  
	  
	    @RequestMapping(value="/employee/list")
	    public ModelAndView listOfEmployees() {
	        ModelAndView modelAndView = new ModelAndView("showAllEmployee");
	         
	        List<Employee> employees = employeeService.getEmployees();
	        modelAndView.addObject("employees", employees);
	         
	        return modelAndView;
	    }
	  
	  
	  
}
