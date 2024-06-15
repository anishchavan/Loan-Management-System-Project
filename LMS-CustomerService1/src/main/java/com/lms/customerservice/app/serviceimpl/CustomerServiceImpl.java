package com.lms.customerservice.app.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.customerservice.app.enums.CustomerLoanStatus;
import com.lms.customerservice.app.model.CustomerDetails;
import com.lms.customerservice.app.repository.CustomerRepository;
import com.lms.customerservice.app.servicei.CustomerServiceI;

@Service
public class CustomerServiceImpl  implements CustomerServiceI{

	@Autowired
	CustomerRepository cr;
	
	@Override
	public CustomerDetails saveCustomerDetails(CustomerDetails cd) {
		CustomerDetails customer=cr.save(cd);
		
		return customer;
	}

	@Override
	public Iterable<CustomerDetails> getCustomerDetails() {
		
		return cr.findAll();
	}

	@Override
	public void deleteCustomer(int customerId) {
		cr.deleteById(customerId);
		
	}

	/*
	 * @Override public Iterable<CustomerDetails> getCustomerByLoanStatus(String
	 * customerLoanStatus) {
	 * 
	 * return cr.findByCustomerLoanStatus(customerLoanStatus); }
	 */



	@Override
	public Optional<CustomerDetails> findById(int customerId) {
		return cr.findById(customerId);
	}

	
	}

	
	
		
	

	

