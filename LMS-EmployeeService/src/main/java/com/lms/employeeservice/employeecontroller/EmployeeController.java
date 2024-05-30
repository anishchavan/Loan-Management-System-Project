package com.lms.employeeservice.employeecontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lms.employeeservice.employeeservicei.EmployeeServiceI;
import com.lms.employeeservice.model.Employee;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeServiceI esi;
	@PostMapping("/employee")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee emp){
		Employee employee = esi.saveEmployee(emp);
		return new ResponseEntity<Employee>(employee, HttpStatus.CREATED);
	}
}
