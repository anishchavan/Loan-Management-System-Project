package com.lms.customerservice.app.servicei;

import java.util.Optional;

import com.lms.customerservice.app.model.CustomerDetails;

public interface CustomerServiceI {

	CustomerDetails saveCustomerDetails(CustomerDetails cd);

	Iterable<CustomerDetails> getCustomerDetails();

	void deleteCustomer(int customerId);

	

	

}
