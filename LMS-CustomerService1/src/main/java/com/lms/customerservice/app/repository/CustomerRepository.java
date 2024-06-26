package com.lms.customerservice.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lms.customerservice.app.model.CustomerDetails;

public interface CustomerRepository extends JpaRepository<CustomerDetails, Integer>{

	Iterable<CustomerDetails> findByCustomerLoanStatus(String customerLoanStatus);

	CustomerDetails findByUsernameAndPassword(String username, String password);

	

}
