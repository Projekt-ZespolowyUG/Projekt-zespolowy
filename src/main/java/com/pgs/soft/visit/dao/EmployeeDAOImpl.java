package com.pgs.soft.visit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pgs.soft.visit.domain.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void addEmployee(Employee employee) {
		getCurrentSession().save(employee);
	}

	public void updateEmployee(Employee employee) {
		Employee employeeToUpdate = getEmployee(employee.getId());
		employeeToUpdate.setFirstName(employee.getFirstName());
		employeeToUpdate.setLastName(employee.getLastName());

		employeeToUpdate.setEmail(employee.getEmail());
		employeeToUpdate.setTelephoneNumber(employee.getTelephoneNumber());

		employeeToUpdate.setAdress(employee.getAdress());
		employeeToUpdate.setPostcode(employee.getPostcode());
		employeeToUpdate.setTown(employee.getTown());
		employeeToUpdate.setCountry(employee.getCountry());

		employeeToUpdate.setUser(employee.getUser());
		employeeToUpdate.setOutpost(employee.getOutpost());

		getCurrentSession().update(employeeToUpdate);

	}

	public Employee getEmployee(Long id) {
		Employee employee = (Employee) getCurrentSession().get(Employee.class, id);
		return employee;
	}

	public void deleteEmployee(Long id) {
		Employee employee = getEmployee(id);
		if (employee != null)
			getCurrentSession().delete(employee);
	}

	@SuppressWarnings("unchecked")
	public List<Employee> getEmployees() {
		return getCurrentSession().createQuery("from Employee").list();
	}

	@SuppressWarnings("unchecked")
	public List<Employee> filterEmployees(String firstName, String lastName, String telephoneNumber, String email) {
		return getCurrentSession()
				.createQuery("from Employee where firstName = :firstName or lastName = :lastName "
						+ "telephoneNumber = :telephoneNumber or idCustomer = :idCustomer")
				.setParameter("firstName", firstName).setParameter("lastName", lastName)
				.setParameter("telephoneNumber", telephoneNumber).setParameter("email", email).list();

	}

}