package com.pgs.soft.visit.service;

import java.util.List;
import com.pgs.soft.visit.domain.Employee;
public interface EmployeeService {

    
   public void addEmployee(Employee Employee);
   public List<Employee> getEmployees();
}
