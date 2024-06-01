package com.lms.employeeservice.employeecontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lms.employeeservice.employeeservicei.EmployeeServiceI;
import com.lms.employeeservice.model.Employee;

import jakarta.ws.rs.Path;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeServiceI esi;
	@PostMapping("/employee")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee emp){
		Employee employee = esi.saveEmployee(emp);
		System.out.println("checking for push");
		System.out.println("Changes by Sujata");
		return new ResponseEntity<Employee>(employee, HttpStatus.CREATED);
	}
	
	@GetMapping("/login/{un}/{ps}")
	public ResponseEntity<Employee> loginEmployee(@PathVariable String un, @PathVariable String ps){
		Employee authEmp = esi.loginEmployee(un, ps);
		System.out.println("sop added in login api");
		System.out.println("sop added by rakhi...");
		return new ResponseEntity<Employee>(authEmp,HttpStatus.OK);
	}
}
