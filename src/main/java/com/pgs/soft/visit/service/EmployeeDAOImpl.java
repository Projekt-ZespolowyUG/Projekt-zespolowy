package com.pgs.soft.visit.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.pgs.soft.visit.domain.Employee;

public class EmployeeDAOImpl {
	  @Autowired
	    private SessionFactory sessionFactory;
	     
	    private Session getCurrentSession() {
	        return sessionFactory.getCurrentSession();
	    }
	 
	    public void addTeam(Employee employee) {
	        getCurrentSession().save(employee);
	    }
	 	 
	    @SuppressWarnings("unchecked")
	    public List<Employee> getEmployees() {
	        return getCurrentSession().createQuery("from Employee").list();
	    }
}
