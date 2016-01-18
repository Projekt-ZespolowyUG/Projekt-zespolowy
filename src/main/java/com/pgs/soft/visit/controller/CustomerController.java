package com.pgs.soft.visit.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import com.pgs.soft.visit.domain.Customer;
import com.pgs.soft.visit.service.CustomerService;
import com.pgs.soft.visit.validation.CustomerValidator;

@Controller
@RequestMapping(value = "/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private CustomerValidator customerValidator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(customerValidator);
	}


	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<Customer> listCustomers() {

		return customerService.getCustomers();
	}
	
	@RequestMapping(value = "/filter", method = RequestMethod.GET)
	public List<Customer> filterCustomers(
			@RequestParam String firstName,
			@RequestParam String lastName,
			@RequestParam String telephoneNumber) {

		List<Customer> source = customerService.getCustomers();
		List<Customer> outcome = new ArrayList<Customer>();
		
		for (int i = 0; i < source.size(); i++) {
			Customer c = source.get(i);
			if( c.getFirstName().equals(firstName) )
			{
				outcome.add(c);
			}
			else if( c.getLastName().equals(lastName) )
			{
				outcome.add(c);
			}
			else if( c.getTelephoneNumber().equals(telephoneNumber) )
			{
				outcome.add(c);
			}
		
		}
		return outcome;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void addOutpost(@ModelAttribute @Valid Customer customer) {

		if (customer.getId() == null) {


			customerService.addCustomer(customer);
		} else {

			customerService.updateCustomer(customer);
		}
		customerService.addCustomer(customer);

	}

	@RequestMapping(value = "/get/{id}")
	public Customer getCustomer(@PathVariable("id") Long id) {

		return customerService.getCustomer(id);
	}
	
	@RequestMapping(value = "/delete/{id}")
	public void deleteCustomer(@PathVariable("id") Long id) {

		customerService.deleteCustomer(id);
	}


}
