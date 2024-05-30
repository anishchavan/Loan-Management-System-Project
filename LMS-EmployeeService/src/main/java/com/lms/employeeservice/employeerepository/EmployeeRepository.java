package com.lms.employeeservice.employeerepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lms.employeeservice.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
