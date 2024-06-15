package com.lms.customerservice.app.servicei;

import com.lms.customerservice.app.model.CustomerDetails;
import com.lms.customerservice.app.model.SanctionLetter;

public interface SanctionServiceI {

	CustomerDetails generateSactionId(int customerId, SanctionLetter sanctionLetter);

}
