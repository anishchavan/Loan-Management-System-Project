package com.lms.customerservice.app.servicei;

import com.google.common.base.Optional;
import com.lms.customerservice.app.model.CustomerDetails;

public interface CustomerServiceI {

	CustomerDetails saveCustomerDetails(CustomerDetails cd);

	Iterable<CustomerDetails> getCustomerDetails();

	void deleteCustomer(int customerId);

	Iterable<CustomerDetails> getCustomerByLoanStatus(String customerLoanStatus);

	CustomerDetails getCustomerById(int customerId);

	CustomerDetails loginCheck(String username, String password);
	
	



	

	

}
