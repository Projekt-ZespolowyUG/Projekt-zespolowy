package com.pgs.soft.visit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pgs.soft.visit.domain.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void addCustomer(Customer customer) {
		getCurrentSession().save(customer);
	}

	public void updateCustomer(Customer customer) {
		Customer customerToUpdate = getCustomer(customer.getId());

		customerToUpdate.setFirstName(customer.getFirstName());
		customerToUpdate.setLastName(customer.getLastName());
		customerToUpdate.setTelephoneNumber(customer.getTelephoneNumber());
		getCurrentSession().update(customerToUpdate);

	}

	public void deleteCustomer(Long id) {

		Customer customer = getCustomer(id);
		if (customer != null) {
			getCurrentSession().delete(customer);
		}
	}

	@SuppressWarnings("unchecked")
	public List<Customer> getCustomers() {
		return getCurrentSession().createQuery("from Customer").list();
	}

	public Customer getCustomer(Long id) {
		Customer customer = (Customer) getCurrentSession().get(Customer.class, id);
		return customer;
	}

	@SuppressWarnings("unchecked")
	public List<Customer> filterCustomers(String firstName, String lastName, String telephoneNumber) {
		return getCurrentSession()
				.createQuery(
						"from Employee where firstName = :firstName or lastName = :lastName or telephoneNumber = :telephoneNumber")
				.setParameter("firstName", firstName).setParameter("lastName", lastName)
				.setParameter("telephoneNumber", telephoneNumber).list();
	}
}
