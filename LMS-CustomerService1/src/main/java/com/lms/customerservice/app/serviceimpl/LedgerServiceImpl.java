package com.lms.customerservice.app.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lms.customerservice.app.model.CustomerDetails;
import com.lms.customerservice.app.repository.CustomerRepository;
import com.lms.customerservice.app.servicei.LedgerServiceI;

@Service
public class LedgerServiceImpl implements LedgerServiceI{
	
	@Autowired
    CustomerRepository cr;

	@Override
	@Transactional
	public CustomerDetails saveCustomerLedger(CustomerDetails customerDetails) {
		
		return cr.save(customerDetails);
	}
    
    

}
