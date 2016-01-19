package com.pgs.soft.visit.service;

import java.util.List;
import com.pgs.soft.visit.domain.Employee;
import com.pgs.soft.visit.domain.Employee;

public interface EmployeeService {

	public void addEmployee(Employee employee);

	public List<Employee> getEmployees();

	public List<Employee> filterEmployees(String firstName, String lastName, String telephoneNumber, String email);

	public void updateEmployee(Employee employee);

	public Employee getEmployee(Long id);

	public void deleteEmployee(Long id);
}