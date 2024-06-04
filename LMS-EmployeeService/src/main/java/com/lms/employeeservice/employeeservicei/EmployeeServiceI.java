package com.lms.employeeservice.employeeservicei;

import java.util.List;

import com.lms.employeeservice.model.Employee;

public interface EmployeeServiceI {

	Employee saveEmployee(Employee emp);

	Employee loginEmployee(String un, String ps);

	List<Employee> getEmployees();

}
