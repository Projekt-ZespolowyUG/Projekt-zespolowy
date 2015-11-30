package com.pgs.soft.visit.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pgs.soft.visit.domain.Employee;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	  @Autowired
	    private EmployeeDAO employeeDAO;
	 	 	 
	    public List<Employee> getEmployees() {
	        return employeeDAO.getEmployees();
	    }

		@Override
		public void addEmployee(Employee Employee) {
			// TODO Auto-generated method stub
			
		}
	 
}
