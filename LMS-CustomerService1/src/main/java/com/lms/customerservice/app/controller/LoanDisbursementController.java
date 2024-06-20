package com.lms.customerservice.app.controller;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.customerservice.app.enums.CustomerLoanStatus;
import com.lms.customerservice.app.exception.CustomerNotFound;
import com.lms.customerservice.app.model.CustomerDetails;
import com.lms.customerservice.app.model.LoanDisbursement;
import com.lms.customerservice.app.repository.CustomerRepository;
import com.lms.customerservice.app.repository.LoanDisbursementRepository;
import com.lms.customerservice.app.servicei.LoanDisbursementServiceI;

@CrossOrigin("*")
@RestController
@RequestMapping("/loanDisbursement")
public class LoanDisbursementController {

	@Autowired
	LoanDisbursementServiceI ls;
	@Autowired
	CustomerRepository cr;
	
	@PutMapping("/loanDisbursementupdate/{customerId}")
	public ResponseEntity<CustomerDetails> updateLoan(@RequestBody LoanDisbursement loandisbursement,@PathVariable int customerId) throws IOException
	{ 
		Optional<CustomerDetails> customer = cr.findById(customerId);
		CustomerDetails customerdata = customer.get();
		if(customer.isEmpty()) {			
			throw new CustomerNotFound();
		}else {		
			customerdata.setCustomerLoanStatus(String.valueOf(CustomerLoanStatus.LoanDisbursed));
			customerdata.getLoanDisbursement().setAgreementDate(loandisbursement.getAgreementDate());
			customerdata.getLoanDisbursement().setTotalLoanSanctionedAmount(loandisbursement.getTotalLoanSanctionedAmount());
			customerdata.getLoanDisbursement().setTransferedAmount(loandisbursement.getTransferedAmount());
			customerdata.getLoanDisbursement().setAmountPaidDate(loandisbursement.getAmountPaidDate());
			customerdata.getLoanDisbursement().setPaymentStatus(loandisbursement.getPaymentStatus());
			customerdata.getLoanDisbursement().setBankName(loandisbursement.getBankName());
			customerdata.getLoanDisbursement().setBankAccountNumber(loandisbursement.getBankAccountNumber());
			customerdata.getLoanDisbursement().setBankIfscCode(loandisbursement.getBankIfscCode());
			customerdata.getLoanDisbursement().setAccountType(loandisbursement.getAccountType());
			
			CustomerDetails customerdetails=ls.updateloanDisbursement(customerdata);
			
			return new ResponseEntity<CustomerDetails>(customerdetails,HttpStatus.OK);
		}		
	}

}
