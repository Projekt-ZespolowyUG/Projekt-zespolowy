package com.pgs.soft.visit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pgs.soft.visit.domain.Customer;
import com.pgs.soft.visit.dao.*;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDAO;

	public void addCustomer(Customer customer) {
		customerDAO.addCustomer(customer);

	}

	public List<Customer> getCustomers() {
		return customerDAO.getCustomers();
	}

	public void updateCustomer(Customer outpost) {
		customerDAO.updateCustomer(outpost);
	}

	public Customer getCustomer(Long id) {
		return customerDAO.getCustomer(id);
	}

	public void deleteCustomer(Long id) {
		customerDAO.deleteCustomer(id);
	}
	public List<Customer> filterCustomers(String firstName, String lastName, String telephoneNumber)
	 {
		return customerDAO.filterCustomers(firstName, lastName, telephoneNumber);
	 }

}