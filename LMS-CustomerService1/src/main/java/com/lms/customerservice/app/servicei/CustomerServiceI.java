package com.lms.customerservice.app.servicei;

import com.lms.customerservice.app.model.CustomerDetails;

public interface CustomerServiceI {

	CustomerDetails saveCustomerDetails(CustomerDetails cd);

	Iterable<CustomerDetails> getCustomerDetails();

	void deleteCustomer(int customerId);

	Iterable<CustomerDetails> getCustomerByLoanStatus(String customerLoanStatus);

	CustomerDetails getCustomerById(int customerId);

//	Iterable<CustomerDetails> getCustomerByLoanStatus(String customerLoanStatus);

	

	

}
