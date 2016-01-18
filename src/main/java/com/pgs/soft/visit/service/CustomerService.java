package com.pgs.soft.visit.service;

import java.util.List;

import com.pgs.soft.visit.domain.Customer;


public interface CustomerService {
	   
	   public void addCustomer(Customer customer);
	   public List<Customer> getCustomers();
	   public void updateCustomer(Customer Customer);
	   public Customer getCustomer(Long id);
	   public void deleteCustomer(Long id);
}
