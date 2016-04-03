
package com.pgs.soft.visit.dao;

import java.util.List;

import com.pgs.soft.visit.domain.Employee;

public interface EmployeeDAO {

	public void addEmployee(Employee employee);

	public List<Employee> getEmployees();

	public List<Employee> filterEmployees(String firstName, String lastName, String telephoneNumber, String email,String adress, String postcode, String town, String country, Long idOutpost);

	public void updateEmployee(Employee employee);

	public Employee getEmployee(Long id);

	public void deleteEmployee(Long id);
}