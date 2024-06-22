package com.lms.customerservice.app.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.customerservice.app.model.CustomerDetails;
import com.lms.customerservice.app.repository.CustomerRepository;
import com.lms.customerservice.app.servicei.LoanDisbursementServiceI;

@Service
public class LoanDisbursementServiceImpl implements LoanDisbursementServiceI{
	
	@Autowired
	CustomerRepository cr;

	@Override
	public CustomerDetails updateloanDisbursement(CustomerDetails customerdata) {
	
		return cr.save(customerdata);
	}

}
