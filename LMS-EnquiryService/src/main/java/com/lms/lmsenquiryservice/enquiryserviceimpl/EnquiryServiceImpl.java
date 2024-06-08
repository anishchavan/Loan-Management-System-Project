package com.lms.lmsenquiryservice.enquiryserviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.lmsenquiryservice.enquiryrepository.EnquiryRepository;
import com.lms.lmsenquiryservice.enquiryservicei.EnquiryServiceI;
import com.lms.lmsenquiryservice.model.Enquiry;
@Service
public class EnquiryServiceImpl implements EnquiryServiceI {
	@Autowired
	EnquiryRepository er;
	@Override
	public Enquiry registerApplicant(Enquiry e) {
		return er.save(e);
	}
	@Override
	public List<Enquiry> getApplicants() {
		return (List<Enquiry>) er.findAll();
	}
	@Override
	public Iterable<Enquiry> getEnquiry(String cibilStatus) {
		
		Iterable<Enquiry> get = er.findAllByCibilStatus(cibilStatus);
		return get;
	}

	@Override
	public Optional<Enquiry> getSingleEnquiry(Integer enqid) {
		
		Optional<Enquiry> findById = er.findById(enqid);
		return findById;
	}

	@Override
	public Optional<Enquiry> findById(Integer enquiryId) {
		
		return er.findById(enquiryId);

	}

	
	

}
