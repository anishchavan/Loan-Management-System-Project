package com.lms.employeeservice.employeeserviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.employeeservice.employeerepository.EmployeeRepository;
import com.lms.employeeservice.employeeservicei.EmployeeServiceI;
import com.lms.employeeservice.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeServiceI {

	@Autowired
	EmployeeRepository er;

	@Override
	public Employee saveEmployee(Employee emp) {
		return er.save(emp);
	}

	@Override
	public Employee loginEmployee(String un, String ps) {
		return er.findByUsernameAndPassword(un,ps);
	}

	@Override
	public List<Employee> getEmployees() {
		return er.findAll();
	}
	
	
	
}
