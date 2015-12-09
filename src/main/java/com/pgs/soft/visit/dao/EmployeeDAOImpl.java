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

	@SuppressWarnings("unchecked")
	public List<Employee> getEmployees() {
		return getCurrentSession().createQuery("from Employee").list();
	}
}