package com.pgs.soft.visit.dao;


import java.util.List;

import com.pgs.soft.visit.domain.Customer;

public interface CustomerDAO {
	public void addCustomer(Customer Customer);
	public List<Customer> getCustomers();
	public List<Customer> filterCustomers(String firstName, String lastName, String telephoneNumber);
	public void updateCustomer(Customer Customer);
	public Customer getCustomer(Long id);
	
	public void deleteCustomer(Long id);
}
