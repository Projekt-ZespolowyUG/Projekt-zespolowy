package com.pgs.soft.visit.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pgs.soft.visit.domain.Employee;
import com.pgs.soft.visit.domain.Employee;
import com.pgs.soft.visit.dao.*;
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	
	 @Autowired
	    private EmployeeDAO employeeDAO;
	 	 	 
	 

		public void addEmployee(Employee employee) {
			 employeeDAO.addEmployee(employee); 
			
		}
	    public List<Employee> getEmployees() {
	        return employeeDAO.getEmployees();
	    }
	    
	    public void updateEmployee(Employee employee) {
	        employeeDAO.updateEmployee(employee);
	    }
	 
	    public Employee getEmployee(Long id) {
	        return employeeDAO.getEmployee(id);
	    }


	 
}