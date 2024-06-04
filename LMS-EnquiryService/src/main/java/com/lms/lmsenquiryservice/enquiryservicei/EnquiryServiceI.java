package com.lms.lmsenquiryservice.enquiryservicei;

import java.util.List;

import com.lms.lmsenquiryservice.model.Enquiry;

public interface EnquiryServiceI {

	Enquiry registerApplicant(Enquiry e);

	List<Enquiry> getApplicants();

}
