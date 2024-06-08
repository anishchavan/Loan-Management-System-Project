package com.lms.lmsenquiryservice.enquiryservicei;

import java.util.List;
import java.util.Optional;

import com.lms.lmsenquiryservice.model.Enquiry;

public interface EnquiryServiceI {

	Enquiry registerApplicant(Enquiry e);

	List<Enquiry> getApplicants();

	Iterable<Enquiry> getEnquiry(String cibilStatus);

	Optional<Enquiry> getSingleEnquiry(Integer enqid);
	
	public Optional<Enquiry> findById(Integer enquiryId);
	


}
