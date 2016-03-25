package com.pgs.soft.visit.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import com.pgs.soft.visit.domain.Customer;
import com.pgs.soft.visit.dto.DeletedCustomerDTO;
import com.pgs.soft.visit.dto.DeletedEmployeeDTO;
import com.pgs.soft.visit.service.CustomerService;
import com.pgs.soft.visit.validation.CustomerValidator;
import com.pgs.soft.visit.validation.DeletedCustomerValidator;
import com.pgs.soft.visit.validation.DeletedEmployeeValidator;
import com.pgs.soft.visit.validation.ReferenceToDeletedCustomerException;
import com.pgs.soft.visit.validation.ReferenceToDeletedEmployeeException;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private CustomerValidator customerValidator;
	
	@Autowired
	private DeletedCustomerValidator deletedcustomervalidator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(customerValidator);
	} 

	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<Customer> listCustomers() {

		return customerService.getCustomers();
	}
	
	@RequestMapping(value = "/filter", method = RequestMethod.GET)
	public List<Customer> filterCustomers(
			@RequestParam(value = "firstName", required = false) String firstName,
			@RequestParam(value = "lastName", required = false) String lastName,
			@RequestParam(value = "telephoneNumber",required = false) String telephoneNumber) {

		return customerService.filterCustomers(firstName, lastName, telephoneNumber);
	}
	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Customer addCustomer(@RequestBody @Valid Customer customer) {

		if (customer.getId() == null) {


			customerService.addCustomer(customer);
		} else {

			customerService.updateCustomer(customer);
		}
		return customer;
	}

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public Customer getCustomer(@PathVariable("id") Long id) {

		return customerService.getCustomer(id);
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	@ResponseBody
	public void deleteCustomer(@RequestBody @PathVariable("id") Long id) 	
			throws ReferenceToDeletedCustomerException {
		

		DeletedCustomerDTO deletedcustomer = new DeletedCustomerDTO(id);

		BindException errors = new BindException(deletedcustomer, DeletedCustomerDTO.class.getName());
		deletedcustomervalidator.validate(deletedcustomer, errors);
	

		if (errors.hasErrors()) {
			throw new ReferenceToDeletedCustomerException();
		} else {
			customerService.deleteCustomer(deletedcustomer.transferId());
		}

	}

}
