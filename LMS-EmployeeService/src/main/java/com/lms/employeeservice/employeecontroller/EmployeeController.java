package com.lms.employeeservice.employeecontroller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	Logger log = LoggerFactory.getLogger(EmployeeController.class);
	
	@PostMapping("/employee")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee emp){
		Employee employee = esi.saveEmployee(emp);
		System.out.println("checking for push");
		System.out.println("Changes by Sujata");
		log.info("The employee has registered successfully..");
		return new ResponseEntity<Employee>(employee, HttpStatus.CREATED);
	}
	
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getEmployees(){
		List<Employee> eList = esi.getEmployees();
		log.info("{}", eList);
		log.info("The employees has been retrieved successfully");
		return new ResponseEntity<List<Employee>>(eList, HttpStatus.OK);
	}
	@GetMapping("/login/{un}/{ps}")
	public ResponseEntity<Employee> loginEmployee(@PathVariable String un, @PathVariable String ps){
		Employee authEmp = esi.loginEmployee(un, ps);
		System.out.println("sop added in login api");
		log.info("The employee has successfully logged in");
		return new ResponseEntity<Employee>(authEmp,HttpStatus.OK);
	}
}
